package com.example.oopjavafx;

import com.example.oopjavafx.Main.Online_Course_Site;
import com.example.oopjavafx.User.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



import java.io.IOException;

public class HelloApplication extends Application {
    Stage primaryStage ;

    @Override
    public void start(Stage stage) throws IOException {

        this.primaryStage=stage;
        // initiail login scene
        primaryStage.setScene(logInScene());
       primaryStage.show();
    }

     private Scene logInScene(){

        this.primaryStage.setTitle("Login");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        // Username Label
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        // Username Input
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("username");
        GridPane.setConstraints(usernameInput, 1, 0);

        // Password Label
        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        // Password Input
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("password");
        GridPane.setConstraints(passwordInput, 1, 1);

        // User Type Label
        Label userTypeLabel = new Label("User Type:");
        GridPane.setConstraints(userTypeLabel, 0, 2);

        // User Type ChoiceBox
        ChoiceBox<String> userTypeChoiceBox = new ChoiceBox<>();
        userTypeChoiceBox.getItems().addAll("Student", "Lecturer");
        userTypeChoiceBox.setValue("Student"); // Default value
        GridPane.setConstraints(userTypeChoiceBox, 1, 2);

        // Error Label
        Label errorLabel = new Label();
        GridPane.setConstraints(errorLabel, 1, 3);

        // Sign In Button
        Button signInButton = new Button("Sign In");
        GridPane.setConstraints(signInButton, 1, 4);
        // Sign Up Button
        Button signUpButton = new Button("Sign Up");
        GridPane.setConstraints(signUpButton, 2, 4);


        // Action for Sign In Button
        signInButton.setOnAction(e -> {
            Online_Course_Site.addNewStudent(new Student("mahmoud","mostafa","mahmoud2030m@gmail.com","@#$1245Mnss","012441233","dsee2",true,"eg"));
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            String userType = userTypeChoiceBox.getValue();

            try {
                if(userType.equals("Student")){
                    Online_Course_Site.logInAsStudent(username,password);
                    System.out.println("logged as student");
                }
                else if (userType.equals("Lecturer") ){
                    Online_Course_Site.logInAsLecturer(username,password);
                    System.out.println("logged as lecturer");
                }

                this.primaryStage.setScene( mainAppScene());


            }catch (Exception err){
                errorLabel.setText(err.getMessage());
                errorLabel.setTextFill(Color.RED);
                passwordInput.setText("");

            }
        });
        //action for signup
         signUpButton.setOnAction(e->{
             this.primaryStage.setScene(signUpScene());


         });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, userTypeLabel, userTypeChoiceBox, signInButton, signUpButton,errorLabel);

        return new Scene(grid, 600, 300);

    }
    private Scene signUpScene(){
        this.primaryStage.setTitle("ONLINE COURSE SITE");

        //// YOUR CODE AND LOGIC
        GridPane pane  =new GridPane();




        return new Scene(pane,200,200);
    }
    private Scene mainAppScene(){
        this.primaryStage.setTitle("ONLINE COURSE SITE");

        //// YOUR CODE AND LOGIC
        GridPane pane  =new GridPane();




        return new Scene(pane,200,200);
    }
     private Scene editScene(){

         this.primaryStage.setTitle("User Profile");
         String email,password;
         Label currentEmailLabel, newEmailLabel, currentPasswordLabel, newPasswordLabel, confirmPasswordLabel;
         TextField currentEmailField, newEmailField, currentPasswordField, newPasswordField, confirmPasswordField;
          Button saveButton, deleteButton;

         currentEmailLabel = new Label("Current Email:");
         newEmailLabel = new Label("New Email:");
         currentPasswordLabel = new Label("Current Password:");
         newPasswordLabel = new Label("New Password:");
         confirmPasswordLabel = new Label("Confirm New Password:");

         currentEmailField = new TextField(Online_Course_Site.loginUser.getEmail());
         currentEmailField.setEditable(false);
         newEmailField = new TextField();

         currentPasswordField = new TextField(Online_Course_Site.loginUser.getPassword());
         currentPasswordField.setEditable(false);
         newPasswordField = new TextField();
         confirmPasswordField = new TextField();

         saveButton = new Button("Save Changes");
         deleteButton = new Button("Delete Account");

         VBox layout = new VBox();
         layout.getChildren().add(currentEmailLabel);
         layout.getChildren().add(currentEmailField);
         layout.getChildren().add(newEmailLabel);
         layout.getChildren().add(newEmailField);
         layout.getChildren().add(currentPasswordLabel);
         layout.getChildren().add(currentPasswordField);
         layout.getChildren().add(newPasswordLabel);
         layout.getChildren().add(newPasswordField);
         layout.getChildren().add(confirmPasswordLabel);
         layout.getChildren().add(confirmPasswordField);
         layout.getChildren().add(saveButton);
         layout.getChildren().add(deleteButton);
         layout.setAlignment(Pos.CENTER);


         // Add button action listeners
         saveButton.setOnAction(event -> {
             // Implement validation and update logic for saving changes
             if(newPasswordField.getText().equals(confirmPasswordField.getText())  )
             {

                 try {
                     Online_Course_Site.loginUser.setEmail(newEmailField.getText());
                     Online_Course_Site.loginUser.setPassword(newPasswordField.getText());


                 }catch(IllegalArgumentException e) {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setTitle("Error");
                     alert.setHeaderText("Invalid Email or Password");
                     alert.setContentText("Please ensure the new password are strong contains(capital,small Caracters ,numbers , special signs #,$)"
                             + "and the email are valid");

                     alert.showAndWait();

                 }


                 this.primaryStage.setScene(logInScene());

             }
             else {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Error");
                 alert.setHeaderText("Passwords Don't Match");
                 alert.setContentText("Please ensure the new password and confirm password fields are identical.");
                 alert.showAndWait();
             }

         });

         deleteButton.setOnAction(event -> {
             // Confirmation dialog before deleting account
             Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
             confirmationAlert.setTitle("Delete Account Confirmation");
             confirmationAlert.setHeaderText("Are you sure you want to delete your account?");
             confirmationAlert.setContentText("This action cannot be undone.");

             confirmationAlert.showAndWait();

             if (confirmationAlert.getResult() == ButtonType.OK) {
                 Online_Course_Site.deleteStudent((Student) Online_Course_Site.loginUser);// put the student
                 this.primaryStage.setScene(logInScene());
             }
         });
         return  new Scene(layout, 400, 400);


     }





    public static void main(String[] args) {
        launch();
    }
}