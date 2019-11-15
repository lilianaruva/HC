/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author lilyg
 */
public class LoadingController implements Initializable {
       
    @FXML
    private StackPane rootPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new SplashScreen().start();
    }
    
    class SplashScreen extends Thread{
        @Override
        public void run()
        {
            try
            {
                Thread.sleep(5000);
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root= null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("Active.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();
                /*
                        Stage stg = (Stage) root.getScene().getWindow();
                        stg.close();*/
                        rootPane.getScene().getWindow().hide();
                        
                    }
                });
            }
            catch(InterruptedException ex)
            {
                Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE,null,ex);
            }         
        }
    }
}

