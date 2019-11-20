/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hc;

//import java.awt.event.MouseEvent;
//import javafx.event.

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.*;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.beans.property.*;


/**
 * FXML Controller class
 *
 * @author lilyg
 */
public class ActiveController implements Initializable {

    //variables iniciales SELECCIÓN DE CAMARA
    @FXML
    private Pane paneCamara;

    //variables secundarias APP ACTIVA
    @FXML
    private ImageView btnHelpActive;
    @FXML
    private TextArea txtArea;
    @FXML
    private Pane paneC;
    
    //variables Ayuda ANIMACIÓN
    @FXML
    private Pane paneHelp;
    @FXML
    private Circle circleHelp;
    @FXML
    private Label labelHelp;
    
    private boolean status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void btnHelpEvent(ActionEvent event) {
        paneHelp.setVisible(true);
        labelHelp.setText("");
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline(
            new KeyFrame(
                Duration.seconds(3),
                eventh -> {
                    switch(i.get()){
                        case 0:
                            step(338, 0, false);
                            labelHelp.setText("Escuchar la conversación");
                            i.set(i.get() + 1);
                            break;
                        case 1:
                            step(513, 0, false);
                            labelHelp.setText("Visualizar la cámara");
                            i.set(i.get() + 1);
                            break;
                        case 2:
                            step(687, 0, false);
                            labelHelp.setText("Guardar la conversación");
                            i.set(i.get() + 1);
                            break;
                        case 3:
                            step(1071, 0, false);
                            labelHelp.setText("Cambiar a modo nocturno");
                            i.set(i.get() + 1);
                            break;
                        case 4:
                            step(500,300, true);
                            labelHelp.setText("Visualización de la camara");
                            i.set(i.get() + 1);
                            break;
                        case 5:
                            step(500, 600, true);
                            labelHelp.setText("Texto de la conversación");
                            i.set(i.get() + 1);
                            break;
                        default:
                            step(-38,-38,true);
                            finish();
                            break;
                    }
                } 
            )
        );
timeline.setCycleCount(7);
timeline.play();
    }
    
    void step(double x, double y, boolean s){
         TranslateTransition th = new TranslateTransition(Duration.seconds(1),circleHelp);
         th.setToX(circleHelp.getLayoutX() + x);
         if(s){
         th.setToY(circleHelp.getLayoutY() + y);
         }
         th.play();
    }
    
    
    void finish(){
            paneHelp.setVisible(false);
    }
    
    @FXML
    void btnCheckEvent(ActionEvent event) {
        paneCamara.setVisible(false);
    }
    @FXML
    void btnEyeEvent(ActionEvent event) {
        
        if(paneC.isVisible())
        {
        paneC.setVisible(false);
        txtArea.setPrefSize(704, 413);
        txtArea.setLayoutX(236);
        txtArea.setLayoutY(170);
        }else{
        paneC.setVisible(true);
        txtArea.setPrefSize(704, 159);
        txtArea.setLayoutX(234);
        txtArea.setLayoutY(604);
        }
    }
    @FXML
    void btnToggle(ActionEvent event){
        boolean s= true;
        
    }
}
