/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.client;

import aex.shared.IFonds;
import aex.shared.IEffectenbeurs;
import aex.server.RMIServer;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
    //IEffectenbeurs effectenbeurs;
    Timer pollingTimer;
    private RMIServer server;
    
    public BannerController(AEXBanner b) {
        //temp var:
        banner = b;
        //effectenbeurs = e;
        Random rng = new Random();
        
        pollingTimer = new Timer();
        
        pollingTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    String nieuweKoersen = "";
                    IFonds[] fondsen = null;
                    
                    try {
                        Registry reg = LocateRegistry.getRegistry("srv1.staticvoid.nl", 1099);
                        IEffectenbeurs remoteBeurs = (IEffectenbeurs) reg.lookup("Effectenbeurs");
                        fondsen = remoteBeurs.getKoersen();
                    } catch (RemoteException exception) {
                        System.err.println("Connection error");
                    } catch (NotBoundException exception) {
                        System.err.println("Not bound error");
                    }

                    // IEffectenbeurs remoteBeurs = 
                    //IFonds[] fondsen = e.getKoersen();
                    if (fondsen == null) {
                        b.setKoersen(" ");
                    }else{
                        for (IFonds f : fondsen) {
                            String koers = f.getKoers() + "     ";
                            koers = koers.substring(0, 5);
                            
                            nieuweKoersen += f.getNaam() + " " + koers + "  ";
                        }
                        
                        b.setKoersen(nieuweKoersen);
                    }
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 1000, 1000);
        
    }
    
}
