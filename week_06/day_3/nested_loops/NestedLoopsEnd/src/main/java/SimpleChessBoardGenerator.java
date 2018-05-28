public class SimpleChessBoardGenerator {
// Generate a simple chess boards as strings of below format

//XOXOXOXO
//OXOXOXOX
//XOXOXOXO
//OXOXOXOX
//XOXOXOXO
//OXOXOXOX
//XOXOXOXO
//OXOXOXOX


    public String generateChessBoard() {
        String resultString = "";
        int sideLength = 8;

        for (int row = 0; row < sideLength; row++) {

            for (int column = 0; column < sideLength; column++) {

                //odd row (0th, 2nd, 4th, 6th):  XOXOXOXO
                //even row (1st, 3rd, 5th, 7th): OXOXOXOX

                Boolean shouldBeX = (column % 2 == 0); // even columns (0th, 2nd, 4th, 6th) should be X
                Boolean isEvenRowSoFlipColours = (row % 2 == 1); // but for every second row...
                shouldBeX = (isEvenRowSoFlipColours) ? !shouldBeX : shouldBeX; //...flip X and O
                resultString += shouldBeX ? "X" : "O";

            }

            resultString += System.lineSeparator(); // end each row with a new line
        }

        return resultString;
    }
}
