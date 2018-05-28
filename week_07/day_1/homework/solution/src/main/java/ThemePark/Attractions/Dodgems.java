package ThemePark.Attractions;

import ThemePark.Interfaces.IChargeable;
import ThemePark.Visitors.Visitor;

public class Dodgems extends Attraction implements IChargeable {

    @Override
    public double priceFor(Visitor visitor) {
        boolean shouldBeHalfPrice = (visitor.getAge() <= 12);
        double priceFull = 8.40;
        return shouldBeHalfPrice ? priceFull / 2.0 : priceFull;
    }

    public Dodgems(String name, int funRating) {
        super(name, funRating);
    }
}