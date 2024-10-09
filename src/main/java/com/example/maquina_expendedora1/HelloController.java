package com.example.maquina_expendedora1;

import javafx.fxml.FXML;
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

    public void initialize() {
        System.out.println("Inicializando");

        GridNumerico.addEventFilter(MouseEvent.MOUSE_CLICKED,
                event -> {                    
                    if (event.getTarget() instanceof Button ||
                            ((event.getTarget() instanceof Text) && ((Text) event.getTarget()).getParent() instanceof Button)) {

                        String texto = (event.getTarget() instanceof Button) ? ((Button) event.getTarget()).getText() : ((Text) event.getTarget()).getText();
                        
                        IDAnimal.setText("ID: 0" + texto);
                        
                        switch (Integer.parseInt(texto)) {
                            case 1 -> {
                                Animal.setText("Cabra");
                                Precio.setText("5.20€");
                            }
                            case 2 ->{ 
                                Animal.setText("Perro");
                                Precio.setText("7.50€");
                            }
                            case 3 ->{ 
                                Animal.setText("Gato");
                                Precio.setText("5.00€");
                            }
                            case 4 ->{ 
                                Animal.setText("Loro");
                                Precio.setText("3.50€");
                            }
                            case 5 ->{ 
                                Animal.setText("Burro");
                                Precio.setText("15.00€");
                            }
                            case 6 ->{ 
                                Animal.setText("Tortuga");
                                Precio.setText("2.50€");
                            }
                            case 7 ->{ 
                                Animal.setText("N/A");
                                Precio.setText("0.00€");
                            }
                            case 8 ->{ 
                                Animal.setText("N/A");
                                Precio.setText("0.00€");
                            }
                            case 9 ->{ 
                                Animal.setText("N/A");
                                Precio.setText("0.00€");
                            }   
                        }
                        event.consume();
                    }
                });
                GridDinero.addEventFilter(MouseEvent.MOUSE_CLICKED,
                event -> {                    
                    if (event.getTarget() instanceof Button ||
                            ((event.getTarget() instanceof Text) && ((Text) event.getTarget()).getParent() instanceof Button)) {

                        String texto = (event.getTarget() instanceof Button) ? ((Button) event.getTarget()).getText() : ((Text) event.getTarget()).getText();
                        
                        texto = texto.replace("€", "");
                        
                        String Deuda = Precio.getText();
                        Deuda = Deuda.replace("€", "");
                        float Total = Float.parseFloat(Deuda);

                        Total = Total - Float.parseFloat(texto);
                        
                        Total = Math.round(Total * 100.0) / 100.0f;

                        Precio.setText(Float.toString(Total) + "€");
                        
                        event.consume();
                    }
                });

    }
}