/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Roy
 */
public class Time implements ITime {
    
    int year;
    int month;
    int day;
    int hours;
    int minutes;
    
    /**
    * creation of a Time-object with year y, month m, day d, hours h and
    * minutes m; if the combination of y-m-d refers to a non-existing date 
    * a correct value of this Time-object will be not guaranteed 
    * @param y
    * @param m   1≤m≤12
    * @param d   1≤d≤31
    * @param h   0≤h≤23
    * @param min 0≤m≤59
    */
    public Time(int y, int m, int d, int h, int min)
    {
        if(m<1||m>12)     
        {
            throw new IllegalArgumentException("Month must be between 1 and 12"); 
        }
        if(d<1||d>31)
        {
            throw new IllegalArgumentException("Day must be between 1 and 31");
        }
        if(h<0||h>23)
        {
            throw new IllegalArgumentException("Hours must be between 0 and 23");
        }
        if(min<0||min>59)
        {
            throw new IllegalArgumentException("minutes must be between 0 and 59");
        }
        year = y;
        month = m;
        day = d;
        hours = h;
        minutes = min;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getMonth() {
        return month;        
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public int getMinutes() {
        return minutes;        
    }

    @Override
    public DayInWeek getDayInWeek() {
        GregorianCalendar calendar = new GregorianCalendar(year,month,day,hours,minutes);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        return DayInWeek.values()[weekday];
    }

    @Override
    public ITime plus(int minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int difference(ITime time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(ITime t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
