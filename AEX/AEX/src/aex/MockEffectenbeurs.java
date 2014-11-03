/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Roy
 */
public class MockEffectenbeurs implements IEffectenbeurs {

    private Fonds[] fondsen;
    private Timer wisselTimer;
    private final Random rng = new Random();

    public MockEffectenbeurs() {
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
                koersWisseling();
            }
        }, 1000, 1000);
    }

    public void koersWisseling() {
        for (Fonds f : fondsen) {
            f.moveKoers((rng.nextDouble() - 0.5) / 10);
        }
    }

    @Override
    public IFonds[] getKoersen() {
        return fondsen.clone();
    }

}
