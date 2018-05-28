package ThemePark.Stalls;

import ThemePark.Interfaces.IChargeable;
import ThemePark.Interfaces.IEnjoyable;

public abstract class Stall implements IChargeable, IEnjoyable{
    private String name;
    private String ownerName;
    private int partingSpot;

    private int funRating;

    public Stall(String name, String ownerName, int partingSpot, int funRating)   {
        this.name = name;
        this.ownerName = ownerName;
        this.partingSpot = partingSpot;
        this.funRating = funRating;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getPartingSpot() {
        return partingSpot;
    }

    public int getFunRating(){
        return this.funRating;
    }

}
