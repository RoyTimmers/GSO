/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roy
 */
public class ContactTest {
   
    
    public ContactTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testContact()
    {
        Contact roy = new Contact("Roy");
        assertNotNull(roy);
        assertEquals(roy.getName(), "Roy");
    }
    
    @Test
    public void testAddAppointment()
    {
        Contact roy = new Contact("Roy");
        Appointment app;
        assertFalse(roy.addAppointment(app));
        
        app = new Appointment("Feest",new Period(new Time(2014,10,30,20,00), new Time(2014,10,31,1,00)));
        assertTrue(roy.addAppointment(app));
        
        app = new Appointment("Saai Feest",new Period(new Time(2014,10,30,19,00), new Time(2014,10,30,22,00)));
        assertFalse(roy.addAppointment(app));
    }
    
    @Test
    public void testRemoveAppointment()
    {
        Contact roy = new Contact("Roy");
        Appointment app;
        
        
        app = new Appointment("Feest",new Period(new Time(2014,10,30,20,00), new Time(2014,10,31,1,00)));      
        roy.addAppointment(app);
        roy.removeAppointment(app);
        assertFalse(roy.appointments().hasNext());
    }
    
    @Test
    public void testAppointments()
    {
        Contact roy = new Contact("Roy");
        Appointment app;
        
        
        app = new Appointment("Feest",new Period(new Time(2014,10,30,20,00), new Time(2014,10,31,1,00)));      
        roy.addAppointment(app);
        app = new Appointment("Saai Feest",new Period(new Time(2014,10,30,19,00), new Time(2014,10,30,22,00)));
        roy.addAppointment(app);
        assertNotNull(roy.appointments());
    }
}
