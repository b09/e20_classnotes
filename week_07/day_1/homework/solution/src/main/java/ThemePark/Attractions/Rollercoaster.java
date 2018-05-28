package ThemePark.Attractions;

import ThemePark.Interfaces.IChargeable;
import ThemePark.Interfaces.IRestrictable;
import ThemePark.Visitors.Visitor;

public class Rollercoaster extends Attraction implements IRestrictable, IChargeable {
    @Override
    public Boolean isAllowedTo(Visitor visitor) {
        boolean isTallEnough = visitor.getHeightInCm() >= 145;
        boolean isOldEnough = visitor.getAge() >= 12;
        return isTallEnough && isOldEnough;
    }

    @Override
    public double priceFor(Visitor visitor) {
        boolean shouldBeHalfPrice = (visitor.getAge() <= 12);
        double priceFull = 8.40;
        return shouldBeHalfPrice ? priceFull / 2.0 : priceFull;
    }
    public Rollercoaster(String name, int funRating) {
        super(name, funRating);
    }
}
