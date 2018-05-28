package ThemePark.Attractions;

import ThemePark.Interfaces.IEnjoyable;

public abstract class Attraction implements IEnjoyable {
    String name;
    int funRating;


    public Attraction(String name, int funRating) {
        this.name = name;
        this.funRating = funRating;
    }

    public String getName() {
        return name;
    }

    public int getFunRating(){
        return this.funRating;
    }

}
