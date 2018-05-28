package ThemePark.Stalls;

import ThemePark.Visitors.Visitor;

public class IceCreamStall extends Stall {
    @Override
    public double priceFor(Visitor visitor){
        return 4.10;
    }

    public IceCreamStall(String name, String ownerName, int partingSpot, int funRating)   {
        super(name, ownerName, partingSpot, funRating);
    }
}
