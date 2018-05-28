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
        //for each item in Species Enum
         // get number associated with this Species key from HashMap, or 0 is no number is associated with this Key
        //write a sentence like "We have 5 of Lions. "

        return result;
    }


    public String listAllAnimals(){
        String result = "";
         //for each key in inventory HashMap
            //start with a plural eg. "Lions : "

            //for each animal type in HashMap, check the amount of these animals and
             //for list each animal. eg. "Lion "
             //finish animal type with a " ; "
            // so for 3 lions you'll have "Lions : Lion Lion Lion ; "

         return result;
    }

}
