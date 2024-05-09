package application;


import Course.Course;
import Main.Online_Course_Site;
import User.Lecturer;
import User.Student;
import User.User;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	Student student=new  Student("Abdelrahman", "Sherif", "abdo@gmail.com", "1234_@#$Ab", "123", "123", true, "Egypt");
	String email,password;
    private Label currentEmailLabel, newEmailLabel, currentPasswordLabel, newPasswordLabel, confirmPasswordLabel;
    private TextField currentEmailField, newEmailField, currentPasswordField, newPasswordField, confirmPasswordField;
    private Button saveButton, deleteButton;
    
    Stage Editdata;

    @Override
    public void start(Stage Editdata) throws Exception {
    	this.Editdata=Editdata;
        Editdata.setTitle("Student Profile");
        Stage login = null;
        // Create UI elements
        Editdata.setScene(createEditscene() );
        Editdata.show();
       
        
    }

    private Scene createEditscene() {
    	 currentEmailLabel = new Label("Current Email:");
         newEmailLabel = new Label("New Email:");
         currentPasswordLabel = new Label("Current Password:");
         newPasswordLabel = new Label("New Password:");
         confirmPasswordLabel = new Label("Confirm New Password:");

         currentEmailField = new TextField(student.getEmail());
         currentEmailField.setEditable(false);
         newEmailField = new TextField();

         currentPasswordField = new TextField(student.getPassword()); 
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

         
         Scene scene = new Scene(layout, 400, 400);


         // Add button action listeners
         saveButton.setOnAction(event -> {
             // Implement validation and update logic for saving changes
         	if(newPasswordField.getText().equals(confirmPasswordField.getText())  )
         	{
         		
         		try {
         			student.setEmail(newEmailField.getText());
                 	student.setPassword(newPasswordField.getText());
                 	Editdata.hide();
         			
         		}catch(IllegalArgumentException e) {
         			Alert alert = new Alert(AlertType.ERROR);
                     alert.setTitle("Error");
                     alert.setHeaderText("Invalid Email or Password");
                     alert.setContentText("Please ensure the new password are strong contains(capital,small Caracters ,numbers , special signs #,$)"
                     		+ "and the email are valid");
                     
                     alert.showAndWait();
         			
         		}
         		
             	
             	//login.show();
         		
         	}
         	else {
         		Alert alert = new Alert(AlertType.ERROR);
                 alert.setTitle("Error");
                 alert.setHeaderText("Passwords Don't Match");
                 alert.setContentText("Please ensure the new password and confirm password fields are identical.");
                 alert.showAndWait();
         	}
         	
         });

         deleteButton.setOnAction(event -> {
             // Confirmation dialog before deleting account
             Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
             confirmationAlert.setTitle("Delete Account Confirmation");
             confirmationAlert.setHeaderText("Are you sure you want to delete your account?");
             confirmationAlert.setContentText("This action cannot be undone.");

             confirmationAlert.showAndWait();

             if (confirmationAlert.getResult() == ButtonType.OK) {
                 Online_Course_Site.deleteStudent(student);// put the student
                 Editdata.hide();
             }
         });
         return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//Ab123#$546


