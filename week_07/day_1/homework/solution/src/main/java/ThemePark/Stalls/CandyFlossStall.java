package ThemePark.Stalls;

import ThemePark.Visitors.Visitor;

public class CandyFlossStall extends Stall {

    @Override
    public double priceFor(Visitor visitor){
        return 2.30;
    }

    public CandyFlossStall(String name, String ownerName, int partingSpot, int funRating)   {
        super(name, ownerName, partingSpot, funRating);
    }
}
