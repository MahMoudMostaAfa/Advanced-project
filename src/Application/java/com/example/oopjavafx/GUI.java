package com.example.oopjavafx;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class GUI {
    public static  void logInGUI( Stage primaryStage){

        primaryStage.setTitle("Login");

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
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            String userType = userTypeChoiceBox.getValue();
            // Here, you can add your logic to check username, password, and user type
        });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, userTypeLabel, userTypeChoiceBox, signInButton, signUpButton,errorLabel);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
      }

}
