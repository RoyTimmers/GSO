/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aex;

/**
 *
 * @author Roy
 */
public class Fonds implements IFonds {
    
    String naam;
    double koers;
    
    public Fonds(String n, double k)
    {
        naam = n;
        koers = k;
    }

    @Override
    public String getNaam() {
        return naam;    
    }

    @Override
    public double getKoers() {
        return koers;
    }
    
    public void moveKoers(double delta) {
        koers = koers + delta;
    }
}
