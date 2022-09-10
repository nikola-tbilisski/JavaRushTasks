package com.javarush.task.task35.task3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game = new JFrame();

        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);
        
        game.add(controller.getView());

        game.setLocationRelativeTo(null);
        game.setVisible(true);

//        Model model = new Model();
//// для compress
//        Tile[][] tiles = new Tile[][]{{new Tile(8), new Tile(0), new Tile(0), new Tile(0)},
//                {new Tile(4), new Tile(0), new Tile(0), new Tile(4)},
//                {new Tile(0), new Tile(4), new Tile(4), new Tile(0)},
//                {new Tile(0), new Tile(2), new Tile(0), new Tile(2)}};
//        // для merge
//        //   Tile[][] tiles = new Tile[][]{{new Tile(8), new Tile(0), new Tile(0), new Tile(0)},
//        //           {new Tile(4), new Tile(2), new Tile(2), new Tile(4)},
//        //           {new Tile(4), new Tile(4), new Tile(4), new Tile(0)},
//        //          {new Tile(4), new Tile(4), new Tile(4), new Tile(4)}};
//        //
//        // До
//        for (int i = 0; i < tiles.length; i++) {
//            System.out.println(Arrays.toString(tiles[i]));
//        }
//        System.out.println();
//        //
//        for (int i = 0; i < tiles.length; i++) {
//            System.out.println(model.compressTiles(tiles[i]));
//            // System.out.println(model.mergeTiles(tiles[i]));
//        }
//        System.out.println();
//        //После
//        for (int i = 0; i < tiles.length; i++) {
//            System.out.println(Arrays.toString(tiles[i]));
//        }

    }
}
