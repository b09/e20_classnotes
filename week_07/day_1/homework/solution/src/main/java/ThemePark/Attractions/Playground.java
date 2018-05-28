package ThemePark.Attractions;

import ThemePark.Interfaces.IRestrictable;
import ThemePark.Visitors.Visitor;

public class Playground extends Attraction implements IRestrictable{

    public Boolean isAllowedTo(Visitor visitor){
        Boolean isYoungEnough = visitor.getAge() <= 15;
        return isYoungEnough;
    }

    public Playground(String name, int funRating) {
        super(name, funRating);
    }
}
