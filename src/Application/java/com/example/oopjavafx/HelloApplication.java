package com.example.oopjavafx;

import com.example.oopjavafx.Main.Online_Course_Site;
import com.example.oopjavafx.User.Student;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;

public class HelloApplication extends Application {
    Stage primaryStage ;

    @Override
    public void start(Stage stage) throws IOException {
        // initial student account
        Online_Course_Site.addNewStudent(new Student("mahmoud","mostafa","mahmoud2030m@gmail.com","@#$1245Mnss","012441233","dsee2",true,"eg"));

        this.primaryStage=stage;
        // initial login scene
        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        this.primaryStage.getIcons().add(icon);
        primaryStage.setScene(logInScene());
        primaryStage.show();
    }


private Scene logInScene() {
    this.primaryStage.setTitle("Login");
    VBox container = new VBox(10); // VBox to hold all elements vertically
    container.setPadding(new Insets(20));

    // Username Label
    Label usernameLabel = new Label("Username:");
    // Username Input
    TextField usernameInput = new TextField();
    usernameInput.setPromptText("username");
    // Password Label
    Label passwordLabel = new Label("Password:");
    // Password Input
    PasswordField passwordInput = new PasswordField();
    passwordInput.setPromptText("password");
    // User Type Label
    Label userTypeLabel = new Label("User Type:");
    // User Type ChoiceBox
    ChoiceBox<String> userTypeChoiceBox = new ChoiceBox<>();
    userTypeChoiceBox.getItems().addAll("Student", "Lecturer");
    userTypeChoiceBox.setValue("Student"); // Default value
    // Hbox for user type
    HBox userTypeBox = new HBox(5);
    VBox.setMargin(userTypeBox, new Insets(0, 0, 20, 0));
    userTypeBox.setAlignment(Pos.CENTER);
    userTypeBox.getChildren().addAll(userTypeLabel,userTypeChoiceBox);

    // Error Label
    Label errorLabel = new Label();

    // HBox for Sign In and Sign Up buttons
    HBox buttonsBox = new HBox(50);
    buttonsBox.setAlignment(Pos.CENTER); // Align buttons to the left

    // Sign In Button
    Button signInButton = new Button("Sign In");
    // Sign Up Button
    Button signUpButton = new Button("Sign Up");


    // Set action for Sign In Button
    signInButton.setOnAction(e -> {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        String userType = userTypeChoiceBox.getValue();
        this.animateButtonsToBottom(signInButton ,()->{

            try {

                if(userType.equals("Student")){
                    Online_Course_Site.logInAsStudent(username,password);
                    System.out.println("logged as student");
                    this.primaryStage.setScene(editScene());
                    Online_Course_Site.loginUser.displayInfo();
                }
                else if (userType.equals("Lecturer") ){
                    Online_Course_Site.logInAsLecturer(username,password);
                    System.out.println("logged as lecturer");
                    this.primaryStage.setScene(mainAppForLecturerScene());
                }

                // Change the scene accordingly
            } catch (Exception err) {
                errorLabel.setText(err.getMessage());
                errorLabel.setTextFill(Color.RED);
                passwordInput.setText("");
            }

        });


    });

    // Set action for Sign Up Button
    signUpButton.setOnAction(e -> {
        this.animateButtonsToBottom(signUpButton ,()->{
            this.primaryStage.setScene(signUpScene());
        } );


    });

    // Add Sign In and Sign Up buttons to the HBox
    buttonsBox.getChildren().addAll(signInButton, signUpButton);

    // Add all elements to the container
    container.getChildren().addAll(
            usernameLabel, usernameInput,
            passwordLabel, passwordInput, errorLabel,
            userTypeBox,
            buttonsBox // Add HBox instead of Sign In and Sign Up buttons individually

    );

    // Create a new scene with the container, setting its size
    Scene scene = new Scene(container, 450, 400);
    scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
    // Center the container in the stage
    container.setAlignment(Pos.CENTER);

    return scene;
}

    private Scene signUpScene(){
        this.primaryStage.setTitle("ONLINE COURSE SITE");

        //// YOUR CODE AND LOGIC
        GridPane pane  =new GridPane();




        return new Scene(pane,200,200);
    }
    private Scene mainAppForStudentScene(){
        this.primaryStage.setTitle("ONLINE COURSE SITE");

        //// YOUR CODE AND LOGIC
        GridPane pane  =new GridPane();




        return new Scene(pane,200,200);
    }
    private Scene mainAppForLecturerScene(){
        this.primaryStage.setTitle("ONLINE COURSE SITE");

        //// YOUR CODE AND LOGIC
        GridPane pane  =new GridPane();




        return new Scene(pane,200,200);
    }
     private Scene editScene(){

         this.primaryStage.setTitle("User Profile");
         String email,password;
         Label currentEmailLabel, newEmailLabel, currentPasswordLabel, newPasswordLabel, confirmPasswordLabel;
         TextField currentEmailField, newEmailField;
          Button saveButton, deleteButton;
         PasswordField  currentPasswordField, newPasswordField, confirmPasswordField;

         currentEmailLabel = new Label("Current Email:");
         newEmailLabel = new Label("New Email:");
         currentPasswordLabel = new Label("Current Password:");
         newPasswordLabel = new Label("New Password:");
         confirmPasswordLabel = new Label("Confirm New Password:");

         currentEmailField = new TextField(Online_Course_Site.loginUser.getEmail());
         currentEmailField.setEditable(false);
         newEmailField = new TextField();

         currentPasswordField = new PasswordField();
//         currentPasswordField.setEditable(false);
         newPasswordField = new PasswordField();
         confirmPasswordField = new PasswordField();

         saveButton = new Button("Save Changes");
         deleteButton = new Button("Delete Account");
         deleteButton.setStyle("-fx-background-color:red ");

         VBox layout = new VBox(10);
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
        layout.setPadding(new Insets(20));

         // Add button action listeners
         saveButton.setOnAction(event -> {
             // Implement validation and update logic for saving changes
             if(!currentPasswordField.getText().equals(Online_Course_Site.loginUser.getPassword()) ){
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Error");
                 alert.setHeaderText("current password is in correct");
                 alert.setContentText("Please write it well");
                 alert.showAndWait();

             }

             if( newPasswordField.getText().equals(confirmPasswordField.getText())  )
             {

                 try {
                     if(newEmailField.getText().length()>0){
                         Online_Course_Site.loginUser.setEmail(newEmailField.getText());
                     }
                     if(newPasswordField.getText().length()>0){
                         Online_Course_Site.loginUser.setPassword(newPasswordField.getText());
                     }

                     this.primaryStage.setScene(logInScene());


                 }catch(IllegalArgumentException e) {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setTitle("Error");
                     alert.setHeaderText(" Invalid Email or Password");
                     alert.setContentText("Please ensure the new password are strong contains(capital,small Caracters ,numbers , special signs #,$)"
                             + "and the email are valid");

                     alert.showAndWait();

                 }



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
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Delete Account Confirmation");
             alert.setHeaderText("Are you sure you want to delete your account?");
             alert.setContentText("This action cannot be undone.");
             alert.showAndWait();

             if (alert.getResult() == ButtonType.OK) {
                 Online_Course_Site.deleteStudent(Online_Course_Site.loginUser.getId());// put the student
                 for(Student S : Online_Course_Site.getStudents()){
                     System.out.println(S.getEmail());
                 }
                 this.primaryStage.setScene(logInScene());
                 Online_Course_Site.loginUser.displayInfo();
             }
         });
         Scene scene =new Scene(layout,400,500);
         scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
         return  scene;


     }



    private void animateButtonsToBottom(Button btn,Runnable onAnimationFinished ) {
        TranslateTransition moveDown = new TranslateTransition(Duration.seconds(0.2), btn);
        moveDown.setToY(10); // Move buttons downwards by 100 pixels

        TranslateTransition moveUp = new TranslateTransition(Duration.seconds(0.2), btn);
        moveUp.setToY(0); // Move buttons back to their original position

        SequentialTransition sequentialTransition = new SequentialTransition(moveDown, moveUp);
        sequentialTransition.play();
       sequentialTransition.setOnFinished( actionEvent -> {
           if (onAnimationFinished != null) {
               onAnimationFinished.run();
           }
       } );
    }

    public static void main(String[] args) {
        launch();
    }
}