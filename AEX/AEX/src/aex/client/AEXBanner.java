/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.client;

import aex.shared.IEffectenbeurs;
import aex.server.RMIServer;
import java.rmi.RemoteException;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Bart
 */
public class AEXBanner extends javafx.application.Application {

    private FXMLController controller;
    private BannerController bannerController;
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
    public AEXBanner() throws RemoteException {
        bannerController = new BannerController(this);
    }

    public void setKoersen(String koersen) {
        controller.bannerText.setText(koersen);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });
        

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("FXML.fxml").openStream());
        controller = (FXMLController) loader.getController();
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("AEX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
