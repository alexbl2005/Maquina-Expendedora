module com.example.maquina_expendedora1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.maquina_expendedora1 to javafx.fxml;
    exports com.example.maquina_expendedora1;
}