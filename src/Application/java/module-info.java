module com.example.oopjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oopjavafx to javafx.fxml;
    exports com.example.oopjavafx;
}