package com.example.fe.map;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquareTile implements Tile {

    private Rectangle mesh;
    private SquareTile[] neighbors;
    private int neighborNum = -1, mov, tileSize;

    private int[] xy; // id of Tile

    public SquareTile() {
        neighbors = new SquareTile[4];
        tileSize = 16;
        mesh = new Rectangle(tileSize, tileSize);
        xy = new int[2];
        // set rectangle color properties
        mesh.setStroke(Color.gray(.5));
        mesh.setStrokeWidth(3);
    }

    public SquareTile(int mov, int tileSize, int x, int y) {
        mesh = new Rectangle();
        mesh.setHeight(tileSize);
        mesh.setWidth(tileSize);

        this.tileSize = tileSize;

        xy = new int[2];
        xy[0] = x;
        xy[1] = y;

        // set rectangle color properties
        mesh.setStroke(Color.gray(.5));
        mesh.setStrokeWidth(3);

        neighbors = new SquareTile[4];

    }

    public void setNeighborhood() {
        
    }

    public void addNeighbor(SquareTile t) {
        if (neighborNum < 3){
            neighbors[++neighborNum] = t;
        } else {
            System.out.println("Error: cannot add new neighbor");
        }

    }


    @Override
    public Tile getNeighborByIndex(int index) {
        return null;
    }

    @Override
    public void removeNeighborByIndex(int index) {

    }

    @Override
    public int getMov() {
        return 0;
    }

    @Override
    public void setMov(int mov) {

    }

    public Rectangle getMesh() {
        return mesh;
    }

    public void setXY(int x, int y) {
        this.xy[0] = x;
        this.xy[1] = y;
    }


    public int[] getXY(){
        return this.xy;
    }
}
