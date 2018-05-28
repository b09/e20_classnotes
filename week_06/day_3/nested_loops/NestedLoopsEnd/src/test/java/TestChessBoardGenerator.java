import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestChessBoardGenerator {
    String boardForPrinting;
    ChessBoardGenerator boardGenerator;
    String boardForPrinting5Sided;
    String boardForPrinting8Sided;

    @Before
    public void before(){
        boardForPrinting = "";
        boardGenerator = new ChessBoardGenerator();
        boardForPrinting5Sided = boardGenerator.generateChessBoard(5);
        boardForPrinting8Sided = boardGenerator.generateChessBoard(8);
        System.out.println(boardForPrinting5Sided);
        System.out.println(boardForPrinting8Sided);

    }


    @Test
    public void generateFirstLineOf8SidedBoard(){
        String expectedBeginningOfString = "  ABCDEFGH";
        assertEquals(expectedBeginningOfString, boardForPrinting8Sided.substring(0,expectedBeginningOfString.length()));
    }

    @Test
    public void generateFirstTwoLinesOf8SidedBoard(){
        String expectedBeginningOfString = "  ABCDEFGH"+System.lineSeparator()+System.lineSeparator()+"1 XOXOXOXO";
        assertEquals(expectedBeginningOfString, boardForPrinting8Sided.substring(0,expectedBeginningOfString.length()));
    }

    @Test
    public void generateWhole8SidedBoard(){
        String expectedBeginningOfString = "  ABCDEFGH"+System.lineSeparator()+System.lineSeparator()+"1 XOXOXOXO"+System.lineSeparator()+"2 OXOXOXOX"+System.lineSeparator()+"3 XOXOXOXO"+System.lineSeparator()+"4 OXOXOXOX"+System.lineSeparator()+"5 XOXOXOXO"+System.lineSeparator()+"6 OXOXOXOX"+System.lineSeparator()+"7 XOXOXOXO"+System.lineSeparator()+"8 OXOXOXOX";
        assertEquals(expectedBeginningOfString, boardForPrinting8Sided.substring(0,expectedBeginningOfString.length()));
    }

    @Test
    public void generateWhole5SidedBoard(){
        String expectedBeginningOfString = "  ABCDE"+System.lineSeparator()+System.lineSeparator()+"1 XOXOX"+System.lineSeparator()+"2 OXOXO"+System.lineSeparator()+"3 XOXOX"+System.lineSeparator()+"4 OXOXO"+System.lineSeparator()+"5 XOXOX";
        assertEquals(expectedBeginningOfString, boardForPrinting5Sided.substring(0,expectedBeginningOfString.length()));
    }
}
