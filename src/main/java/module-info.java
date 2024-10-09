module com.example.maquina_expendedora1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.maquina_expendedora1 to javafx.fxml;
    exports com.example.maquina_expendedora1;
}