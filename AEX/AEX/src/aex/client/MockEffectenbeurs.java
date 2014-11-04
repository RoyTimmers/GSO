/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex.client;

import aex.shared.IFonds;
import aex.shared.IEffectenbeurs;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roy
 */
public class MockEffectenbeurs extends UnicastRemoteObject implements IEffectenbeurs {

    private Fonds[] fondsen;
    private Timer wisselTimer;
    private final Random rng = new Random();

    public MockEffectenbeurs() throws RemoteException  {
        Fonds cisco = new Fonds("CISCO", 15);
        Fonds philips = new Fonds("PHILIPS", 27);
        Fonds postnl = new Fonds("POSTNL", 12);
        Fonds asml = new Fonds("ASML", 10);
        Fonds pepsico = new Fonds("PEPSICO", 20);
        Fonds ahold = new Fonds("AHOLD", 17);
        
        fondsen = new Fonds[]{cisco,philips,postnl,asml,pepsico,ahold};
        
        wisselTimer = new Timer();

        wisselTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    koersWisseling();
                } catch (RemoteException ex) {
                    Logger.getLogger(MockEffectenbeurs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 1000, 1000);
    }

    public void koersWisseling() throws RemoteException  {
        for (Fonds f : fondsen) {
            f.moveKoers((rng.nextDouble() - 0.5) / 10);
        }
    }

    @Override
    public IFonds[] getKoersen() {
        return fondsen.clone();
    }

}
