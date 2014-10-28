/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Roy
 */
public class Contact {
    private final String name;
    private ArrayList<Appointment> agenda;
    
    public Contact(String name)
    {
        this.name = name;
        agenda = new ArrayList<Appointment>();
    }
    
    public String getName()
    {
        return name;
    }
    
    boolean addAppointment(Appointment a)
    {
        for (Appointment app : agenda)
        {
            if (app.getPeriod().intersectionWith(a.getPeriod())=null)
            {
                agenda.add(a);
                return true;
            }
        }
        return false;
    }
    
    boolean removeAppointment(Appointment a)
    {
        for (Appointment app : agenda)
        {
            if(app.equals(a))
            {
                agenda.remove(app);
            }
        }
    }
    
    public Iterator<Appointment> appointments()
    {
        return agenda;
    }
    
    
}
