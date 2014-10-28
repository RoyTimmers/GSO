/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author Roy
 */
public class Period2 implements IPeriod {
    
    Time beginTijd;
    long duur;

    public Period2(Time begintijd, long Duur)
    {
        beginTijd=begintijd;
        duur=Duur;
    }
    @Override
    public ITime getBeginTime() {
        return beginTijd;
    }

    @Override
    public ITime getEndTime() {
        Time eindTijd = (Time) beginTijd.plus((int)duur);
        return eindTijd;
    }

    @Override
    public int length() {
            
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEndTime(ITime endTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(int minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeLengthWith(int minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPartOf(IPeriod period) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPeriod unionWith(IPeriod period) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPeriod intersectionWith(IPeriod period) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
