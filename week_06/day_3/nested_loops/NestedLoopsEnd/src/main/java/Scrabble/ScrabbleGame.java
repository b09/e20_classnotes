package Scrabble;

import java.util.ArrayList;

public class ScrabbleGame {
    ArrayList<ScrabbleTile> tiles;

    public ScrabbleGame() {
        initilizeTiles();
    }

    public void initilizeTiles(){
        tiles = new ArrayList<ScrabbleTile>();

        //for each tile type :
        for (ScrabbleTileType tileType : ScrabbleTileType.values()){
            //create as many tiles as there should be in the set, and...
            for (int i = 0; i < tileType.getHowManyInSet() ; i++) {
                //add each new tile to the set
                tiles.add( new ScrabbleTile(tileType.name().charAt(0), tileType.getScore()) );
            }
        }
    }

    public int tilesLeftCount(){
        return tiles.size();
    }
}
