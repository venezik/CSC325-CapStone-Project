module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires com.google.auth;
    requires java.net.http;
    requires org.json;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
}