package com.example.fe.map;

public interface Tile {
    /*
    * This Tile interface will be used as a template
    * for all tile objects.
    * */

    static int numOfTiles = 0;

    Tile getNeighborByIndex(int index);
    void removeNeighborByIndex(int index);

    int getMov();
    void setMov(int mov);


}
