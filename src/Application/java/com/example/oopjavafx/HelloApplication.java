package com.example.oopjavafx;

import com.example.oopjavafx.Course.Course;
import com.example.oopjavafx.Main.Online_Course_Site;
import com.example.oopjavafx.User.Lecturer;
import com.example.oopjavafx.User.Student;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    String inputText1 , inputText2 , inputText3  ;
    double inputText5 ;
    private double  withdraw  ;
    Stage primaryStage ;
    String imagePath = null;

    @Override
    public void start(Stage stage) throws IOException {
        // initial student account
        Online_Course_Site.addNewStudent(new Student("mahmoud","mostafa","mahmoud2030m@gmail.com","@#$1245Mnss","012441233","\\Users\\asd\\Pictures\\Screenshots\\Screenshot 2024-05-12 131129.png",true,"eg"));

        Online_Course_Site.addNewLecturer(new Lecturer("asfcdhgv","dewahg","abdo@gmail.com","1#$@45Ab","011","eywg",true,"co"));
        Online_Course_Site.getLecturers().get(0).publicCourse("AVR","AVRasnf aksbfkasbfkjabsfkabsfkabsf",50,"hsga");
        Online_Course_Site.addNewStudent(new Student("Omar", "Tamer", "omar@gmail.com", "Omar@000", "01111","eywg",true, "egypt" ));
        Online_Course_Site.getLecturers().get(0).publicCourse("tech","AVRasjfnakjvbadbvkadbvkbadkvabv",50,"hsga");

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

                    this.primaryStage.setScene(mainAppForStudentScene());
                    this.primaryStage.setFullScreen(true);


                }
                else if (userType.equals("Lecturer") ){
                    Online_Course_Site.logInAsLecturer(username,password);

                    System.out.println("logged as lecturer");
                    this.primaryStage.setScene(mainAppForLecturerScene());
                    this.primaryStage.setFullScreen(true);
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
        this.primaryStage.setTitle("Signup");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20.0));


        gridPane.setHgap(10.0);
        gridPane.setVgap(10.0);


        Label firstNameLabel = new Label("First Name:");
        TextField firstNameField = new TextField();

        gridPane.add(firstNameLabel, 0, 0);
        gridPane.add(firstNameField, 1, 0);

        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameField = new TextField();

        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameField, 1, 1);

        Label genderLabel = new Label("Gender:");
        ToggleGroup genderToggleGroup = new ToggleGroup();
        RadioButton maleRadioButton = new RadioButton("Male");
        maleRadioButton.setToggleGroup(genderToggleGroup);
        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setToggleGroup(genderToggleGroup);
        maleRadioButton.setSelected(true);
        gridPane.add(genderLabel, 0, 2);
        gridPane.add(maleRadioButton, 1, 2);
        gridPane.add(femaleRadioButton, 2, 2);
        Label phoneLabel = new Label("Phone:");
        TextField phoneField = new TextField();
        gridPane.add(phoneLabel, 0, 3);
        gridPane.add(phoneField, 1, 3);

        Label countryLabel = new Label("Country:");
        TextField countryField = new TextField();
        gridPane.add(countryLabel, 0, 4);
        gridPane.add(countryField, 1, 4);

        ImageView imageView = new ImageView();
        imageView.setFitHeight(50.0);
        imageView.setFitWidth(50.0);

        Button imageButton = new Button("Select Image");
        imageButton.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                imageView.setImage(image);
                this.imagePath = file.getAbsolutePath();
            }

        });
        HBox hBox = new HBox(new Node[]{imageView, imageButton});
        hBox.setAlignment(Pos.TOP_RIGHT);
        gridPane.add(hBox, 2, 0, 1, 1);
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        gridPane.add(emailLabel, 0, 6);
        gridPane.add(emailField, 1, 6);
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordLabel, 0, 7);
        gridPane.add(passwordField, 1, 7);
        Label userTypeLabel = new Label("User Type:");
        ToggleGroup userTypeToggleGroup = new ToggleGroup();
        RadioButton studentRadioButton = new RadioButton("Student");
        studentRadioButton.setToggleGroup(userTypeToggleGroup);
        RadioButton lecturerRadioButton = new RadioButton("Lecturer");
        lecturerRadioButton.setToggleGroup(userTypeToggleGroup);
        studentRadioButton.setSelected(true);
        gridPane.add(userTypeLabel, 0, 8);
        gridPane.add(studentRadioButton, 1, 8);
        gridPane.add(lecturerRadioButton, 2, 8);
        Button signupButton = new Button("Sign Up");
        Label errorMessageLabel = new Label();
        gridPane.add(errorMessageLabel, 0, 10, 2, 1);
        Button BackToLogin = new Button("back to login");
        gridPane.add(BackToLogin, 2, 9, 2, 1);
        BackToLogin.setOnAction( (e)->{
            this.primaryStage.setScene(logInScene());
        });
        signupButton.setOnAction((event) -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            boolean gender = maleRadioButton.isSelected()? true : false ;
            String phone = phoneField.getText();
            String country = countryField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String userType = studentRadioButton.isSelected()? "student": "lecturer";
            if (!firstName.isEmpty() && !lastName.isEmpty()  && !phone.isEmpty() && !country.isEmpty() && !email.isEmpty() && !password.isEmpty() && imagePath!=null) {
              try {
                  if (userType.equals("student"))  Online_Course_Site.addNewStudent(new Student(firstName,lastName,email,password,phone,imagePath,gender,country));
                  else Online_Course_Site.addNewLecturer(new Lecturer(firstName,lastName,email,password,phone,imagePath,gender,country));
                  imagePath=null;
                  this.primaryStage.setScene(logInScene());
                  for (Student s : Online_Course_Site.getStudents()){
                      s.displayInfo();
                  }
                  for (Lecturer s : Online_Course_Site.getLecturers()){
                      s.displayInfo();
                  }

              }catch (Exception e){
                  errorMessageLabel.setText(e.getMessage());
                  errorMessageLabel.setTextFill(Color.RED);
              }
            } else {

                errorMessageLabel.setText("Please fill in all the required fields.");
                errorMessageLabel.setTextFill(Color.RED);
            }
        });
        gridPane.add(signupButton, 1, 9);

        Scene scene =new Scene(gridPane, 480, 450.0);

        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());

        return  scene ;
    }
    private Scene mainAppForStudentScene(){
        Student student= (Student)Online_Course_Site.getLoginUser() ;
        this.primaryStage.setTitle("ONLINE COURSE SITE");

        BorderPane root = new BorderPane();
        TextField charge = new TextField();
        charge.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    charge.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        Label alert = new Label();
        // Labels for student name and balance
        Label nameLabel = new Label("Name: " + student.getFirstName() + " " + student.getLastName());
        nameLabel.setTextFill(Color.WHITE);
        Label balanceLabel = new Label("Balance: $" + student.getWallet());
        balanceLabel.setTextFill(Color.WHITE);
        Button chargebalance = new Button("✅");
        chargebalance.setOnAction(e-> {
            try {
                student.addToWallet(Integer.parseInt(charge.getText()));
            }catch (Exception ex){
                alert.setText(ex.getMessage());
                alert.setTextFill(Color.RED);
            }

            charge.clear();
            balanceLabel.setText("Balance: $" + student.getWallet());
        });

        // List views for registered, finished, and available courses
        ListView<String> registeredCoursesListView = new ListView<>();




        for (Course course : student.getEnrolledCourses()){
            registeredCoursesListView.getItems().addAll( course.getName() +"lecturer name :"+ course.getInstructorName() +" course price :" + course.getPrice()  );
        }


        ListView<String> finishedCoursesListView = new ListView<>();
        for (Course course : student.getFinsihedCourse()){
            registeredCoursesListView.getItems().addAll( course.getName() +"lecturer name :"+ course.getInstructorName() +" course price :" + course.getPrice()  );
        }

        ListView<String> availableCoursesListView = new ListView<>();

        for (Course course : Online_Course_Site.getCourses()){
            availableCoursesListView.getItems().addAll( "course name: "+ course.getName() +"lecturer name : "+ course.getInstructorName() +" course price : " + course.getPrice()  );
        }
        availableCoursesListView.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item);
                    setPrefWidth(200); // Set custom width for cell
                }
            }
        });
        // Buttons for actions
        Button withdrawButton = new Button("Withdraw");
        Button registerButton = new Button("Register");
        Button logoutButton = new Button("Logout");
        Button editButton = new Button("Edit");
        withdrawButton.setVisible(false);
        registerButton.setVisible(false);
//        Image profile = new Image(Online_Course_Site.loginUser.getImage());
//        ImageView profileImageView = new ImageView(profile);
//        profileImageView.setFitHeight(50);
//        profileImageView.setFitWidth(50);
        charge.setPrefSize(70,30);
        chargebalance.setPrefSize(60,30);
        editButton.setOnAction((e)->{
            this.primaryStage.setScene(editScene());
        });

        logoutButton.setOnAction((e)->{
            this.primaryStage.setScene(logInScene());
    Online_Course_Site.logOut();
} );
        // Horizontal box for buttons
        HBox buttonsBox = new HBox(10 ,withdrawButton, registerButton, editButton, logoutButton);
        buttonsBox.setPadding(new Insets(10));
        HBox full = new HBox(10);
        HBox Balance = new HBox(10);
        Balance.getChildren().addAll(charge, chargebalance);
        HBox info = new HBox(10, new VBox(5, nameLabel, balanceLabel, Balance,alert));
        info.setAlignment(Pos.CENTER);
//        full.getChildren().addAll(profileImageView, info);
        full.getChildren().addAll( info);
        full.setPadding(new Insets(20));
        full.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setLeft(full);
        root.setRight(buttonsBox);


        // getting buttons to appear when a course is clicked
        // Registering event handlers for ListView selection changes
        registeredCoursesListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Show withdraw button when a registered course is selected
                withdrawButton.setVisible(newValue != null);
                if (registerButton.isVisible()) {
                    registerButton.setVisible(false);
                }

            }

        });

        availableCoursesListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Show register button when an available course is selected
                registerButton.setVisible(newValue != null);
                if (withdrawButton.isVisible()) {
                    withdrawButton.setVisible(false);
                }
            }
        });

        //Buttons action
        withdrawButton.setOnAction(e -> {
            String drawn = registeredCoursesListView.getSelectionModel().getSelectedItem();
            registeredCoursesListView.getItems().remove(registeredCoursesListView.getSelectionModel().getSelectedIndex());
            // search for drawn and delete it in enrolled courses

            availableCoursesListView.getItems().add(drawn);
            registeredCoursesListView.getSelectionModel().clearSelection();
            withdrawButton.setVisible(false);
        });

        registerButton.setOnAction(e->{
            String registered = availableCoursesListView.getSelectionModel().getSelectedItem();
            availableCoursesListView.getItems().remove(availableCoursesListView.getSelectionModel().getSelectedIndex());
            registeredCoursesListView.getItems().add(registered);
            availableCoursesListView.getSelectionModel().clearSelection();
            registerButton.setVisible(false);
        });


        VBox fullcourses = new VBox(10);
        fullcourses.setPadding(new Insets(10));
        fullcourses.getChildren().addAll(
                new Label("Registered Courses"),
                registeredCoursesListView, new Label("Finished Courses")
                , finishedCoursesListView, new Label("Available Courses")
                , availableCoursesListView);

        root.setCenter(fullcourses);
        // Create scene and set it on stage
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        logoutButton.getStyleClass().add("info");
        return  scene;
    }
    
    private Scene mainAppForLecturerScene(){
                Lecturer loggedLecturer = (Lecturer)Online_Course_Site.getLoginUser();
                BorderPane root = new BorderPane();
                StackPane root2 = new StackPane();
                this.primaryStage.setTitle("Online Course System - Lecturer View");


                root.setPadding(new Insets(10));


                Label titleLabel = new Label(" Online Course System - [Lecturer View] ");
                titleLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-color : Blue; ");
                titleLabel.setTextFill(Color.BLUEVIOLET);
                StackPane.setAlignment(titleLabel, Pos.CENTER);
                BorderPane.setAlignment(titleLabel, Pos.CENTER);

                root.setTop(titleLabel);

                // Sidebar with navigation
                VBox TopBox1 = new VBox(15);
                TopBox1.setPrefWidth(200);   // width of the vbox
                TopBox1.setPadding(new Insets(20));
                //Button myCoursesBtn = new Button("My Courses");
                // Button createCourseBtn = new Button("Create Course");
                TextField balancefield = new TextField();

                Button AddStudent = new Button("Add Student");
                Button RomoveStudent = new Button("Remove Student");
                Button WithdrawBalance = new Button("Withdraw");

                ImageView LecturerImage = new ImageView(loggedLecturer.getImage());
                Label LecturerName = new Label("Name: " + loggedLecturer.getFirstName());
                Label LecturerEmail = new Label("Email: " + loggedLecturer.getEmail());
                Label LecturerBalance = new Label("Balance: " + loggedLecturer.getBalance() + "$");
                Label TotalStudent = new Label("Total Student: " + loggedLecturer.getTotalStudent());
                Label Withdrawlabel = new Label("Withdraw Amount:");
                Label errorText = new Label();
                balancefield.setOnAction(event -> {
                    withdraw = Double.parseDouble(balancefield.getText());
                    ;

                });

                WithdrawBalance.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // Call a method from the existing class when the button is clicked
                        try {
                            loggedLecturer.withDrawMoney(withdraw);
                        }catch (Exception e){
                            errorText.setText(e.getMessage());
                            errorText.setTextFill(Color.RED);
                        }

                        // TotalStudent.setText("Total Student: " + lecturer.get());
                        LecturerBalance.setText("Balance: " + loggedLecturer.getBalance() + "$");
                    }
                });

                TextField courseName = new TextField();
                TextField courseDescription = new TextField();
                TextField coursePrice = new TextField();
                TextField category = new TextField();

                Label NameOfCourse = new Label("Course Name");
                Label Description = new Label("Course Description");
                Label Price = new Label("Course Price");
                Label Category = new Label("Course Category");
                Label showcourses = new Label("");


                //////////////////////////////////////////
                //ADDING A NEW COURSE
                /////////////////////////////////////////

                Button Addbtn = new Button("Add Course");
                Button Removebtn = new Button("Remove Course");
                Button Addconfirm = new Button("Add");

                Label course1Label = new Label("Course 1: Introduction to Java");
                Label course2Label = new Label("Course 2: Web Development Basics");
                Label course3Label = new Label("Course 3: Database Management");

                courseName.setVisible(false);
                NameOfCourse.setVisible(false);
                courseDescription.setVisible(false);
                Description.setVisible(false);
                coursePrice.setVisible(false);
                Price.setVisible(false);
                category.setVisible(false);
                Category.setVisible(false);
                Addconfirm.setVisible(false);


                Addbtn.setOnAction(event -> {

                    courseName.setVisible(true);
                    NameOfCourse.setVisible(true);
                    courseDescription.setVisible(true);
                    Description.setVisible(true);
                    coursePrice.setVisible(true);
                    Price.setVisible(true);
                    category.setVisible(true);
                    Category.setVisible(true);
                    Addconfirm.setVisible(true);

                    loggedLecturer.publicCourse(inputText1, inputText2, inputText5, inputText3);
                    // for (int i=0 ; i < lecturer.courses.size())

                    //showcourses.setText(lecturer.getCourses() );
                });


                Removebtn.setOnAction(event -> {

                    course3Label.setVisible(false);


                });


                courseName.setOnAction(event -> {
                    inputText1 = courseName.getText();

                });
                courseDescription.setOnAction(event -> {
                    inputText2 = courseDescription.getText();
                });
                coursePrice.setOnAction(event -> {
                    inputText5 = Double.parseDouble(balancefield.getText());
                    ;
                });
        /*instructorName.setOnAction(event -> {
            inputText3 = instructorName.getText();
        });*/
                category.setOnAction(event -> {
                    inputText3 = category.getText();
                });

                Addconfirm.setOnAction(event -> {

                    courseName.setVisible(false);
                    NameOfCourse.setVisible(false);
                    courseDescription.setVisible(false);
                    Description.setVisible(false);
                    coursePrice.setVisible(false);
                    Price.setVisible(false);
                    category.setVisible(false);
                    Category.setVisible(false);
                    Addconfirm.setVisible(false);

                    loggedLecturer.publicCourse(inputText1, inputText2, inputText5, inputText3);
                    // for (int i=0 ; i < lecturer.courses.size())

                    showcourses.setText("" + loggedLecturer.getCourses());
                });


                TopBox1.getChildren().addAll(
                        LecturerImage,
                        LecturerName,
                        LecturerEmail,
                        LecturerBalance,
                        Withdrawlabel,
                        balancefield,
                        WithdrawBalance,
                        errorText,
                        TotalStudent,
                        NameOfCourse,
                        courseName,
                        Description,
                        courseDescription,
                        Price,
                        coursePrice,
                        Category,
                        category,
                        Addconfirm);


                root.setLeft(TopBox1);

                // Course overview
                VBox courseOverview = new VBox(10);
                courseOverview.setPadding(new Insets(10));



        /*courseOverview.getChildren().addAll();
        root.setRight(courseOverview);*/

                // BOTTOM LEFT BUTTONS
                VBox BottomBox1 = new VBox(10);
                BottomBox1.setPadding(new Insets(20));
                BottomBox1.setStyle("-fx-background-color: #f0f0f0;");
                Button logoutBtn = new Button("Logout");
                Button editbutton = new Button("Edit");
                BottomBox1.getChildren().addAll(editbutton, logoutBtn);
                root.setBottom(BottomBox1);

                VBox Box2 = new VBox(80);
                Box2.setPrefWidth(400);
                Label MyCourse = new Label("My Cousres: ");
                //Label RegisterCourse2 = new Label("Register Course: ");
                Box2.setPadding(new Insets(20));
                Box2.setStyle("-fx-background-color: #f0f0f0;");
                Box2.getChildren().addAll(Addbtn, Removebtn, MyCourse, course1Label, course2Label, course3Label);
                root.setCenter(Box2);


                Scene scene = new Scene(root, 1500, 780);
                return scene;




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
         Label errorlabel = new Label();


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
         layout.getChildren().add(errorlabel);
         layout.getChildren().add(saveButton);
         layout.getChildren().add(deleteButton);
         layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));


         // Add button action listeners
         saveButton.setOnAction(event -> {
             // Implement validation and update logic for saving changes
             if(!currentPasswordField.getText().equals(Online_Course_Site.loginUser.getPassword()) ){

                 errorlabel.setText("Error : current password is in correct");
                 errorlabel.setTextFill(Color.RED);

             }

             if( newPasswordField.getText().equals(confirmPasswordField.getText())  )
             {

                 try {

                     Online_Course_Site.loginUser.setEmail(newEmailField.getText());
                     Online_Course_Site.loginUser.setPassword(newPasswordField.getText());

                     Online_Course_Site.logOut();
                      this.primaryStage.setScene(logInScene());



                 }catch(IllegalArgumentException e) {

                     errorlabel.setText("Error : Invalid Email or Password");
                     errorlabel.setTextFill(Color.RED);

                 }



             }
             else {

                 errorlabel.setText("Error : Passwords Don't Match make sure the two passwords are the same");
                 errorlabel.setTextFill(Color.RED);

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
                 if(Online_Course_Site.getLoginUser() instanceof  Student)  Online_Course_Site.deleteStudent((Student) Online_Course_Site.getLoginUser());
                 else  Online_Course_Site.deleteLecturer((Lecturer) Online_Course_Site.getLoginUser());
                 this.primaryStage.setScene(logInScene());

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