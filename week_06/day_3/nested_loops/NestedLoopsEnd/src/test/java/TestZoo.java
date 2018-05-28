import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestZoo {
    Zoo edinburghZoo;

    @Before
    public void before(){
        HashMap<Species, Integer> inventory = new HashMap<Species, Integer>();
        inventory.put(Species.BEAR, 2);
        inventory.put(Species.LION, 5);
        inventory.put(Species.CROCODILE, 3);
        inventory.put(Species.PLATYPHUS, 12);

        edinburghZoo = new Zoo("Edinburgh", inventory);
    }

    @Test
    public void testReportInventoryOfAllKnowSpecies(){
        String expectedInventory = "We have 5 of Lions. We have 2 of Bears. We have 3 of Crocodiles. We have 12 of Platyphuses. We have 0 of Dodos. ";
        assertEquals(expectedInventory, edinburghZoo.reportInventoryOfKnowSpecies());
        System.out.println(edinburghZoo.reportInventoryOfKnowSpecies());
    }

    @Test
    public void testListAllAnimals(){
        String expectedInventory = "Platyphuses : Platyphus Platyphus Platyphus Platyphus Platyphus Platyphus Platyphus Platyphus Platyphus Platyphus Platyphus Platyphus ; Crocodiles : Crocodile Crocodile Crocodile ; Bears : Bear Bear ; Lions : Lion Lion Lion Lion Lion ; ";
        assertEquals(expectedInventory, edinburghZoo.listAllAnimals());
        System.out.println(edinburghZoo.listAllAnimals());
    }
}
