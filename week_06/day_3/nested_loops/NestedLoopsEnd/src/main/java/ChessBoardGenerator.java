public class ChessBoardGenerator {
// Generate chess boards as strings of below format, given the length of the side. Below example for n = 8

//  ABCDEFGH
//
//1 XOXOXOXO
//2 OXOXOXOX
//3 XOXOXOXO
//4 OXOXOXOX
//5 XOXOXOXO
//6 OXOXOXOX
//7 XOXOXOXO
//8 OXOXOXOX

    public String generateChessBoard(int sideLength){
        String resultString = "";

        //first create the first row with letters, like "  ABCDEFGH"
        resultString += "  "; //add left margin

        for (int columnOfFirstRow = 0; columnOfFirstRow < sideLength ; columnOfFirstRow++) {
            int asciiNumberOfALetter = 65 + columnOfFirstRow; //65 is A, 66 is B, 67 is C, etc
            resultString += (char)asciiNumberOfALetter; //create number from char, eg. (char)65 is 'A'
        }

        resultString += System.lineSeparator(); // end row with a new line

        resultString += System.lineSeparator(); // add another line of margin


        for (int row = 0; row < sideLength ; row++) {

            resultString += (row + 1) + " "; // start row with a row name eg. "1 "

            for (int column = 0; column < sideLength; column++) {
                Boolean shouldBeX = (column % 2 == 0); // even columns should be O
                Boolean isEvenRow = (row % 2 == 1); // but for every second row...
                shouldBeX = (isEvenRow) ? !shouldBeX : shouldBeX; //...flip X and O
                resultString += shouldBeX ? "X" : "O";

            }

            resultString += System.lineSeparator(); // end each row with a new line
        }

        return resultString;
    }
}
