/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Bart
 */
public class FXMLController implements Initializable {

    public Text bannerText;
    Timer animationTimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Make timer
        animationTimer = new Timer();

        animationTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                bannerText.setX(bannerText.getX() + 2);

                if (bannerText.getX() > 500) {
                    bannerText.setX(0-bannerText.getLayoutBounds().getWidth());
                }
            }
        }, 25, 25);

    }
}
