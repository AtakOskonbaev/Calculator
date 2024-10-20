module org.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jdi;


    opens org.example.calculator to javafx.fxml;
    exports org.example.calculator;
}