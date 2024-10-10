package com.example.maquina_expendedora1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import java.text.DecimalFormat;

public class HelloController {

    @FXML
    private GridPane GridNumerico;

    @FXML
    private GridPane GridDinero;

    @FXML
    private Label IDAnimal;

    @FXML
    private Label Animal;

    @FXML
    private Label Precio;

    @FXML
    private Label Cambio;

    @FXML
    private Label Resultado;

    @FXML
    private Button Comprar;

    @FXML
    private Button Cancelar;

    float Dinero;
    float PrecioAnimal;
    int ID;

    int Stock1 = 3;
    int Stock2 = 3;
    int Stock3 = 3;
    int Stock4 = 3;
    int Stock5 = 3;
    int Stock6 = 3;
    int Stock7 = 0;



    public void initialize() {
        System.out.println("Inicializando");

        GridNumerico.addEventFilter(MouseEvent.MOUSE_CLICKED,
                event -> {                    
                    if (event.getTarget() instanceof Button ||
                            ((event.getTarget() instanceof Text) && ((Text) event.getTarget()).getParent() instanceof Button)) {

                        String texto = (event.getTarget() instanceof Button) ? ((Button) event.getTarget()).getText() : ((Text) event.getTarget()).getText();

                        Resultado.setText("");
                        IDAnimal.setText("ID: 0" + texto);
                        
                        switch (Integer.parseInt(texto)) {
                            case 1 -> {
                                Animal.setText("Cabra");
                                Precio.setText("5.20€");
                                PrecioAnimal = 5.20F;
                                ID = 1;
                            }
                            case 2 ->{ 
                                Animal.setText("Perro");
                                Precio.setText("7.50€");
                                PrecioAnimal = 7.50F;
                                ID = 2;
                            }
                            case 3 ->{ 
                                Animal.setText("Gato");
                                Precio.setText("5.00€");
                                PrecioAnimal = 5.00F;
                                ID = 3;
                            }
                            case 4 ->{ 
                                Animal.setText("Loro");
                                Precio.setText("3.50€");
                                PrecioAnimal = 3.50F;
                                ID = 4;
                            }
                            case 5 ->{ 
                                Animal.setText("Burro");
                                Precio.setText("15.00€");
                                PrecioAnimal = 15.00F;
                                ID = 5;
                            }
                            case 6 ->{ 
                                Animal.setText("Tortuga");
                                Precio.setText("2.50€");
                                PrecioAnimal = 2.50F;
                                ID = 6;
                            }
                            case 7, 8, 9 ->{
                                Animal.setText("N/A");
                                Precio.setText("0.00€");
                                PrecioAnimal = 0.00F;
                                ID = 7;
                            }
                        }
                        Dinero = 0F;
                        Cambio.setText("Cambio: 0.00€");
                        event.consume();
                    }
                });
        GridDinero.addEventFilter(MouseEvent.MOUSE_CLICKED,
        event -> {
                    if (event.getTarget() instanceof Button ||
                            ((event.getTarget() instanceof Text) && ((Text) event.getTarget()).getParent() instanceof Button)) {

                        String texto = (event.getTarget() instanceof Button) ? ((Button) event.getTarget()).getText() : ((Text) event.getTarget()).getText();
                        
                        texto = texto.replace("€", "");
                        Dinero = Dinero + Float.parseFloat(texto);
                        String Deuda = Precio.getText();

                        Deuda = Deuda.replace("€", "");

                        float Total = Float.parseFloat(Deuda);

                        if (Dinero > PrecioAnimal)
                        {
                            Precio.setText("0.00€");
                            float cambio = Dinero - PrecioAnimal;

                            cambio = Math.round(cambio * 100.0) / 100.0F;

                            Cambio.setText("Cambio: " + cambio + "€");
                        }else{
                            Total = Total - Float.parseFloat(texto);

                            Total = Math.round(Total * 100.0) / 100.0F;

                            Precio.setText(Float.toString(Total) + "€");
                        }


                        
                        event.consume();
                    }
                });
        Comprar.setOnMouseClicked(
                event -> {

                    if (Dinero >= PrecioAnimal)
                    {
                        IDAnimal.setText("ID: ");
                        Animal.setText("Producto: ");
                        PrecioAnimal = 0.00F;
                        Dinero = 0F;

                        Alert Stock = new Alert(Alert.AlertType.ERROR);
                        Stock.setTitle("Sin stock");
                        Stock.setContentText("No nos queda stock de este producto");

                        Alert Compra = new Alert(Alert.AlertType.INFORMATION);
                        Compra.setTitle("Gracias por su compra");
                        Compra.setContentText("Gracias por su compra, " + Cambio.getText());

                        switch (ID) {
                            case 1 -> {
                                if (Stock1 > 0)
                                {
                                    Resultado.setText("Meeeeeehhh");
                                    Stock1 = Stock1 - 1;
                                    Compra.showAndWait();
                                }else
                                {
                                    Stock.showAndWait();
                                }

                            }
                            case 2 -> {
                                if (Stock2 > 0)
                                {
                                    Resultado.setText("Guau Guau");
                                    Stock2 = Stock2 - 1;
                                    Compra.showAndWait();
                                }else
                                {
                                    Stock.showAndWait();
                                }
                            }
                            case 3 -> {
                                if (Stock3 > 0)
                                {
                                    Resultado.setText("Miau");
                                    Stock3 = Stock3 - 1;
                                    Compra.showAndWait();
                                }else
                                {
                                    Stock.showAndWait();
                                }
                            }
                            case 4 -> {
                                if (Stock4 > 0)
                                {
                                    Resultado.setText("HoOLAaaa");
                                    Stock4 = Stock4 - 1;
                                    Compra.showAndWait();
                                }else
                                {
                                    Stock.showAndWait();
                                }
                            }
                            case 5 -> {
                                if (Stock5 > 0)
                                {
                                    Resultado.setText("Hiiii Hooooo");
                                    Stock5 = Stock5 - 1;
                                    Compra.showAndWait();
                                }else
                                {
                                    Stock.showAndWait();
                                }
                            }
                            case 6 -> {
                                if (Stock6 > 0)
                                {
                                    Resultado.setText("aaaahhhhh");
                                    Stock6 = Stock6 - 1;
                                    Compra.showAndWait();
                                }else
                                {
                                    Stock.showAndWait();
                                }
                            }
                            case 7 -> {
                                Resultado.setText("");
                                Stock.showAndWait();
                            }
                        }
                        Cambio.setText("Cambio: 0.00€");
                    }else
                    {
                        float Resta = PrecioAnimal - Dinero;
                        Resta = Math.round(Resta * 100.0) / 100.0F;

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error dinero insuficiente");
                        alert.setContentText("No has introducido suficiente dinero, le faltan " + Resta + "€");
                        alert.showAndWait();
                    }

                });
        Cancelar.setOnMouseClicked(
                event -> {
                    IDAnimal.setText("ID: ");
                    Animal.setText("Producto: ");
                    Cambio.setText("Cambio: 0.00€");
                    PrecioAnimal = 0.00F;
                    Dinero = 0F;
                    Precio.setText("0.00€");
                });
    }
}