/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Calendar;
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
public class TimeTest {
    
        Time time;
    
    public TimeTest() {
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
    
    /**
     * Test van constructor
     */
    
    @Test(expected = IllegalArgumentException.class)
    public void testMonth()
    {
        /**
        * creation of a Time-object with year y, month m, day d, hours h and
        * minutes m; if the combination of y-m-d refers to a non-existing date 
        * a correct value of this Time-object will be not guaranteed
        * @param m 1≤m≤12
        */  
        time = new Time(2014,13,4,14,0);
        time = new Time(2014,0,12,12,12);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDay()
    {
        /**
        * creation of a Time-object with year y, month m, day d, hours h and
        * minutes m; if the combination of y-m-d refers to a non-existing date 
        * a correct value of this Time-object will be not guaranteed
        * @param d 1≤m≤31
        */  
        time = new Time(2014,12,32,12,12);
        time = new Time(2014,12,0,12,12);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHour()
    {
        /**
        * creation of a Time-object with year y, month m, day d, hours h and
        * minutes m; if the combination of y-m-d refers to a non-existing date 
        * a correct value of this Time-object will be not guaranteed
        * @param h 0≤m≤23
        */  
        time = new Time(2014,12,12,24,12);
        time = new Time(2014,12,12,-1,12);                
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMinute()
    {
        /**
        * creation of a Time-object with year y, month m, day d, hours h and
        * minutes m; if the combination of y-m-d refers to a non-existing date 
        * a correct value of this Time-object will be not guaranteed
        * @param min 0≤m≤59
        */  
        time = new Time(2014,12,12,12,60);
        time = new Time(2014,12,12,12,-1);
    }
    
}
