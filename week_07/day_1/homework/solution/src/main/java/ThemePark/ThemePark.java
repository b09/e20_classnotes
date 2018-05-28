package ThemePark;

import ThemePark.Interfaces.IEnjoyable;

import java.util.ArrayList;

public class ThemePark {
    ArrayList<IEnjoyable> enjoyableAttractions;

    public ThemePark(ArrayList<IEnjoyable> enjoyableAttractions) {
        this.enjoyableAttractions = enjoyableAttractions;
    }

    public String reportEnjoyables(){
        String report = "";
        for (IEnjoyable e: enjoyableAttractions) {
            report += e.getName() + " : " + e.getFunRating() + ", ";

        }
        return report;
    }

}
