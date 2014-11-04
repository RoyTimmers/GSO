/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import aex.server.RMIServer;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roy
 */
public class BannerController {

    AEXBanner banner;
    IEffectenbeurs effectenbeurs;
    Timer pollingTimer;
    private RMIServer server;

    public BannerController(AEXBanner b, IEffectenbeurs e) {
        //temp var:
        banner = b;
        effectenbeurs = e;
        Random rng = new Random();

        pollingTimer = new Timer();

        pollingTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    String nieuweKoersen = "";
                    
                    IFonds[] fondsen = e.getKoersen();
                    
                    for (IFonds f : fondsen) {
                        String koers = f.getKoers() + "";
                        koers = koers.substring(0, 5);
                        
                        nieuweKoersen += f.getNaam() + " " + koers + "  ";
                    }
                    
                    b.setKoersen(nieuweKoersen);
                } catch (RemoteException ex) {
                    Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 1000, 1000);

    }

}
