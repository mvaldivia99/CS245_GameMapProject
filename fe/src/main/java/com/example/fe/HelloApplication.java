package com.example.fe;

import com.example.fe.inventory.Item;
import com.example.fe.map.GameMap;
import com.example.fe.map.SquareTile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/


        //Item i1 = new Item();

        //Item i2 = new Item();

        /*SquareTile tile = new SquareTile();

        GridPane grid = new GridPane();
        grid.add(tile.getMesh(), 32, 32);*/

        GameMap a = new GameMap(15, 15, 32);
        a.populateMap();
        Scene scene = new Scene(a.getGrid(), 500, 500);

        stage.setScene(scene);
        stage.setTitle("Version 1.0.0");
        stage.show();
    }
}
