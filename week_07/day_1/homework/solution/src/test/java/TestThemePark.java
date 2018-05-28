import ThemePark.Attractions.Playground;
import ThemePark.Attractions.Rollercoaster;
import ThemePark.Interfaces.IEnjoyable;
import ThemePark.Stalls.TobaccoStall;
import ThemePark.ThemePark;
import ThemePark.Visitors.Visitor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestThemePark {

    Visitor youngVisitor;
    Visitor parentVisitor;
    Playground playground;
    Rollercoaster rollercoaster;
    ThemePark themePark;
    TobaccoStall tobaccoStall;

    @Before
    public void before(){
        youngVisitor = new Visitor(12, 133, 10.3);
        parentVisitor = new Visitor(37, 183, 40.3);
        playground = new Playground("Happy Tree Friends", 6);
        rollercoaster = new Rollercoaster("Death Stirr", 6);
        tobaccoStall = new TobaccoStall("Smoke Screen", "Dodgy Bill", 3,1);

        ArrayList<IEnjoyable> enjoyableAttractions = new ArrayList<>();
        //Cast Playground and Rollercoaster to IEnjoyable (i.e. treat them as IEnjoyable for the purposes of this line)
        enjoyableAttractions.add((IEnjoyable) playground);
        enjoyableAttractions.add((IEnjoyable) rollercoaster);
        enjoyableAttractions.add((IEnjoyable) tobaccoStall);
        enjoyableAttractions.add((IEnjoyable) ghostTrain);
        enjoyableAttractions.add((IEnjoyable) mascot);

        themePark = new ThemePark(enjoyableAttractions);

    }

    @Test
    public void testAgesPlaygroundYoung(){
        assertEquals(true,playground.isAllowedTo(youngVisitor));
    }

    @Test
    public void testAgesPlaygroundParent(){
        assertEquals(false,playground.isAllowedTo(parentVisitor));
    }

    @Test
    public void testAgesRollercoasterYoung(){
        assertEquals(false,rollercoaster.isAllowedTo(youngVisitor));
    }

    @Test
    public void testAgesRollercoasterParent(){
        assertEquals(true,rollercoaster.isAllowedTo(parentVisitor));
    }

    @Test
    public void testReport(){
        String expectedReport = "Happy Tree Friends : 6, Death Stirr : 6, Smoke Screen : 1, ";
        assertEquals(expectedReport, themePark.reportEnjoyables());
    }
}
