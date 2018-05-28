import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestSimpleChessBoardGenerator {
    SimpleChessBoardGenerator boardGenerator;
    String simpleBoardForPrinting;

    @Before
    public void before(){
        boardGenerator = new SimpleChessBoardGenerator();
        simpleBoardForPrinting = boardGenerator.generateChessBoard();
        System.out.println(simpleBoardForPrinting);
    }

    @Test
    public void generateFirstLineOf8SidedBoard(){
        String expectedBeginningOfString = "XOXOXOXO";
        assertEquals(expectedBeginningOfString, simpleBoardForPrinting.substring(0,expectedBeginningOfString.length()));
    }

    @Test
    public void generateFirstTwoLinesOf8SidedBoard(){
        String expectedBeginningOfString = "XOXOXOXO"+System.lineSeparator()+"OXOXOXOX";
        assertEquals(expectedBeginningOfString, simpleBoardForPrinting.substring(0,expectedBeginningOfString.length()));
    }

    @Test
    public void generateWhole8SidedBoard() {
        String expectedBeginningOfString = "XOXOXOXO" + System.lineSeparator() + "OXOXOXOX" + System.lineSeparator() + "XOXOXOXO" + System.lineSeparator() + "OXOXOXOX" + System.lineSeparator() + "XOXOXOXO" + System.lineSeparator() + "OXOXOXOX" + System.lineSeparator() + "XOXOXOXO" + System.lineSeparator() + "OXOXOXOX" + System.lineSeparator();

        assertEquals(expectedBeginningOfString, simpleBoardForPrinting.substring(0, expectedBeginningOfString.length()));
    }
}
