import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerTest {
    Computer computer;

    @Before
    public void before() {
        computer = new Computer("Keith's Computer", "Apple", "Macbook Pro");
    }

    @Test
    public void hasName(){
        assertEquals("Keith's Computer", computer.getName());
    }

    @Test
    public void hasMake(){
        assertEquals("Apple", computer.getMake());
    }

    @Test
    public void hasModel(){
        assertEquals("Macbook Pro", computer.getModel());
    }

}
