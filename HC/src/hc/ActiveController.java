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
import javafx.animation.TranslateTransition;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void btnHelpEvent(ActionEvent event) {
        paneHelp.setVisible(true);
        TranslateTransition th = new TranslateTransition(Duration.seconds(2),circleHelp);
        th.setToX(circleHelp.getLayoutX()+(10));
        th.play();
        
     //   paneHelp.setVisible(false);
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
