package com.example.fe.map;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class GameMap {
    private int m, n, tileSize;
    protected GridPane grid_p;
    protected ArrayList<ArrayList<SquareTile>> grid_a;

    public GameMap(int h, int w, int tileSize) {
        this.m = w;
        this.n = h;
        this.tileSize = tileSize;
        grid_p = new GridPane();
        grid_a = new ArrayList<>();
    }

    public void populateMap(){

        for (int i = 0; i < m * tileSize; i += tileSize) {
            grid_a.add(new ArrayList<SquareTile>());

            for (int j = 0; j < n * tileSize; j += tileSize) {
                SquareTile t0 = new SquareTile();
                t0.setXY(i / tileSize, j / tileSize);
                grid_a.get(i / tileSize).add(t0);
                grid_p.add(grid_a.get(i / tileSize).getLast().getMesh(), i, j);
            }

        }
    }

    public void setNeighborhoods(){
        for (int i = 0; i < grid_a.size(); i++) {
            for (int j = 0; j < grid_a.get(i).size(); j++) {
                /*
                * For the square tiles, the adjacency list is stored as follows:
                * Look up [0] (i, j - 1)
                * look down [1] (i, j + 1)
                * look left [2] (i - 1, j)
                * look right [3] (i + 1, j)
                * */


                // look up
                // ensure that the coordinates are within bounds
                // ensure that the tile isn't null
                if (j - 1 >= 0 && grid_a.get(i).get(j - 1) != null){
                    grid_a.get(i).get(j).addNeighbor(grid_a.get(i).get(j - 1));
                }

                // look down
                if (j + 1 <= (grid_a.get(i).size() - 2) && grid_a.get(i).get(j + 1) != null){
                    grid_a.get(i).get(j).addNeighbor(grid_a.get(i).get(j + 1));
                }

                // look left
                if (i - 1 >= 0 && grid_a.get(i - 1).get(j) != null){
                    grid_a.get(i).get(j).addNeighbor(grid_a.get(i - 1).get(j));
                }

                // look right
                if (i + 1 <= grid_a.size() - 2 && grid_a.get(i + 1).get(j) != null){
                    grid_a.get(i).get(j).addNeighbor(grid_a.get(i + 1).get(j));
                }
            }
        }


        // confirm adjacency lists
        /*for (int i = 0; i < grid_a.size(); i++) {
            for (int j = 0; j < grid_a.get(i).size(); j++) {
                String nodeID = String.format("(%d, %d)", grid_a.get(i).get(j).getXY()[0], grid_a.get(i).get(0).getXY()[1]);
                System.out.print(nodeID + "->");

                for (int k = 0; k < 4; k++) {
                    String neighbor = String.format(" (%d, %d),", grid_a.get(i).get(j).getNeighborByIndex(k))
                }

                System.out.println();
            }
        }*/
    }

    public GridPane getGrid(){
        return this.grid_p;
    }
}
