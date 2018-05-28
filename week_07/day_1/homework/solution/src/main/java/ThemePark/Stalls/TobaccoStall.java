package ThemePark.Stalls;

import ThemePark.Interfaces.IRestrictable;
import ThemePark.Visitors.Visitor;

public class TobaccoStall extends Stall implements IRestrictable{

    public Boolean isAllowedTo(Visitor visitor){
        Boolean isOldEnough = visitor.getAge() >= 18;
        return isOldEnough;
    }

    @Override
    public double priceFor(Visitor visitor) {
        return 6.20;
    }

    public TobaccoStall(String name, String ownerName, int partingSpot, int funRating)   {
        super(name, ownerName, partingSpot, funRating);
    }
}
