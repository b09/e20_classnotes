import Scrabble.ScrabbleGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestScrabble {
    ScrabbleGame scrabbleGame;

    @Before
    public void before(){
        scrabbleGame = new ScrabbleGame();
    }

    @Test
    public void testHasAllPieces(){
        assertEquals(98, scrabbleGame.tilesLeftCount());
    }
}
