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
 * @author bart
 */
public class PeriodTest {

    Period pEen;
    Period pTwee;
    Period pDrie;
    Period pVier;
    Period pUnionEenTwee;
    Period pIntersectEenTwee;

    public PeriodTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pEen = new Period(
                new Time(2014, 12, 30, 14, 0),
                new Time(2014, 12, 30, 16, 0)
        );

        pTwee = new Period(
                new Time(2014, 12, 30, 15, 0),
                new Time(2014, 12, 30, 17, 0)
        );

        pUnionEenTwee = new Period(
                new Time(2014, 12, 30, 14, 0),
                new Time(2014, 12, 30, 17, 0)
        );

        pIntersectEenTwee = new Period(
                new Time(2014, 12, 30, 15, 0),
                new Time(2014, 12, 30, 16, 0)
        );

        pDrie = new Period(
                new Time(2014, 12, 30, 20, 0),
                new Time(2014, 12, 30, 23, 0)
        );

        pVier = new Period(
                new Time(1970, 1, 1, 0, 0),
                new Time(2020, 1, 1, 0, 0)
        );

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetSet() {
        // TODO review the generated test code and remove the default call to fail.
        Time oldBeginTime = (Time) pEen.getBeginTime();
        Time oldEndTime = (Time) pEen.getEndTime();

        Time checkBeginTime = new Time(1870, 1, 1, 0, 0);
        Time checkEndTime = new Time(1880, 1, 1, 0, 0);

        pEen.setBeginTime(checkBeginTime);
        pEen.setEndTime(checkEndTime);

        assertEquals("Get/set begintime geeft verkeerde value", pEen.getBeginTime(), checkBeginTime);
        assertEquals("Get/set endtime geeft verkeerde value", pEen.getEndTime(), checkEndTime);

        try {
            pEen.setBeginTime(oldBeginTime);
            fail("Begintijd na eindtijd wordt geaccepteerd");
        } catch (IllegalArgumentException exception) {
        }

        // Reset pEen
        pEen.setEndTime(oldEndTime);
        pEen.setBeginTime(oldBeginTime);

        try {
            pEen.setEndTime(checkEndTime);
            fail("Eindtijd voor begintijd wordt geaccepteerd");
        } catch (IllegalArgumentException exception) {
        }

        // Reset pEen
        pEen.setEndTime(oldEndTime);
        pEen.setBeginTime(oldBeginTime);
    }

    @Test
    public void testMove() {
        Period pTest = new Period(
                new Time(1970, 1, 1, 0, 0),
                new Time(2020, 1, 1, 0, 0)
        );

        pTest.move(42);
        assertEquals("Begintijd wordt niet goed vooruit verplaatst", pTest.getBeginTime().getMinutes(), 42);
        assertEquals("Eindtijd wordt niet goed vooruit verplaatst", pTest.getEndTime().getMinutes(), 42);

        pTest.move(0);
        assertEquals("Nul voor begintijd wordt niet geaccepteerd", pTest.getBeginTime().getMinutes(), 42);
        assertEquals("Nul voor begintijd wordt niet geaccepteerd", pTest.getBeginTime().getMinutes(), 42);

        pTest.move(-43);
        assertEquals("Begintijd wordt niet goed achteruit verplaatst", pTest.getBeginTime().getMinutes(), 59);
        assertEquals("Eindtijd wordt niet goed acteruit verplaatst", pTest.getEndTime().getMinutes(), 59);
    }

    @Test
    public void testIsPartOf() {
        assertEquals("isPartOf geeft verkeerde value (false) bij deelperiode", pEen.isPartOf(pVier), true);
        assertEquals("isPartOf geeft verkeerde value (true) bij niet-deelperiode", pTwee.isPartOf(pDrie), false);
        assertEquals("isPartOf geeft verkeerde value (true) bij omgekeerde deelperiode", pVier.isPartOf(pEen), false);
        assertEquals("isPartOf geeft verkeerde value (true) bij overlappende periode", pEen.isPartOf(pTwee) || pTwee.isPartOf(pEen), false);
    }

    @Test
    public void testUnionIntersection() {
        assertEquals("Overlappende union geeft verkeerd resultaat", pEen.unionWith(pTwee), pUnionEenTwee);
        assertEquals("Overlappende intersection geeft verkeerd resultaat", pEen.intersectionWith(pTwee), pIntersectEenTwee);

        assertEquals("Bevattende union geeft verkeerd resultaat", pEen.unionWith(pVier), pVier);
        assertEquals("Bevattende intersection geeft verkeerd resultaat", pEen.intersectionWith(pVier), pEen);

        assertEquals("Nullwaarde moet worden gereturnd bij niet-overlappend union-argument", pEen.unionWith(pDrie), null);
        assertEquals("Nullwaarde moet worden gereturnd bij niet-overlappend intersection-argument", pEen.intersectionWith(pDrie), null);

    }

    @Test
    public void testLength() {
        int oldLength = pEen.length();

        pEen.changeLengthWith(5);
        assertEquals("Lengte wordt niet goed opgeteld", pEen.length(), oldLength + 5);

        pEen.changeLengthWith(-5);
        assertEquals("Lengte wordt niet goed afgetrokken", pEen.length(), oldLength);

        Period pTest = new Period(
                new Time(2014, 1, 1, 0, 0),
                new Time(2014, 1, 1, 0, 5)
        );

        try {
            pTest.changeLengthWith(-10);
            fail("IllegalArgument moet worden gegooid");
        } catch (IllegalArgumentException exception) {
        }
    }
}
