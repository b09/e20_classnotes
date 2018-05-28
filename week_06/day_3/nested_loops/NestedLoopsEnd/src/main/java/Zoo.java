import com.sun.tools.javac.util.StringUtils;

import java.util.HashMap;

public class Zoo {
    HashMap<Species, Integer> inventory;
    String name;

    public Zoo(String name, HashMap<Species, Integer> inventory){
        this.name = name;
        this.inventory = inventory;
    }

    public String reportInventoryOfKnowSpecies(){
        String result = "";
        for (Species s : Species.values()) { //for each item in Species Enum
            Integer numberOfAnimalsOfThisSpecies =  inventory.getOrDefault(s, 0); // get number associated with this Species key from HashMap, or 0 is no number is associated with this Key

            result += "We have "+ numberOfAnimalsOfThisSpecies  + " of " + s.getNamePlural() + ". ";

        }
        return result;
    }


    public String listAllAnimals(){
        String result = "";
        for (Species s : inventory.keySet()) { //for each key in inventory HashMap
            result += s.getNamePlural() + " : "; //start with a plural eg. "Lions : "

            for (int whichAnimalOfThisSpecies = 0; whichAnimalOfThisSpecies < inventory.getOrDefault(s, 0) ; whichAnimalOfThisSpecies++) {
                result += s.getName() + " "; //list each animal. eg. "Lion "
            }
            // so for 3 lions you'll have "Lions : Lion Lion Lion ; "

            result += "; ";

        }
            return result;
    }

}
