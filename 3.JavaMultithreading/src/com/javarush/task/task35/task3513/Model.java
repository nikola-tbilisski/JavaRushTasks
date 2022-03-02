package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score = 0, maxTile = 0;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] savedGameTiles = new Tile[tiles.length][tiles.length];

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                savedGameTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }

        previousStates.push(savedGameTiles);
        previousScores.push(this.score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            this.gameTiles = previousStates.pop();
            this.score = previousScores.pop();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    void resetGameTiles() {
        this.score = 0;
        this.maxTile = 0;

        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTileList = new ArrayList<>();

        for (Tile[] tileArr : gameTiles)
            for (Tile tile : tileArr)
                if (tile.isEmpty())
                    emptyTileList.add(tile);


        return emptyTileList;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int tileIndex = (int) (Math.random() * emptyTiles.size());
            Tile emptyTile = emptyTiles.get(tileIndex);
            emptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        int count = 0;
        boolean change = false;
        Tile[] compareTiles = Arrays.copyOf(tiles, tiles.length);
        Arrays.sort(compareTiles, Comparator.comparing(Tile::isEmpty));

        for (Tile tile : tiles) {
            if (tile.value != 0) {
                tiles[count++].value = tile.value;
            }
        }

        while (count < tiles.length)
            tiles[count++].value = 0;

        if (!Arrays.equals(compareTiles, tiles)) change = true;

        return change;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean change = false;

        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i - 1].value == tiles[i].value && tiles[i - 1].value != 0) {
                int result = tiles[i - 1].value * 2;
                tiles[i - 1].value = result;
                tiles[i].value = 0;
                score += result;
                change = true;
                if (result > maxTile) {
                    maxTile = result;
                }
            }
        }
        compressTiles(tiles);

        return change;
    }

    private Tile[][] rotate(Tile[][] tiles) {
        Tile[][] transposeArray = new Tile[tiles.length][tiles.length];

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                transposeArray[i][j] = tiles[j][i];
            }
        }

        for (int i = 0; i < transposeArray.length; i++) {
            int start = 0;
            int end = transposeArray.length - 1;

            while (start < end) {
                Tile temp = transposeArray[i][start];
                transposeArray[i][start] = transposeArray[i][end];
                transposeArray[i][end] = temp;

                start++;
                end--;
            }
        }
        return transposeArray;
    }

    public void left() {
        boolean moveLeft = false;

        if (isSaveNeeded) saveState(gameTiles);

        for (Tile[] tileArr : gameTiles) {
            if (compressTiles(tileArr) | mergeTiles(tileArr)) {
                moveLeft = true;
            }
        }
        if (moveLeft) addTile();
        isSaveNeeded = true;
    }

    public void up() {
        saveState(this.gameTiles);
        gameTiles = rotate(gameTiles);
        gameTiles = rotate(gameTiles);
        gameTiles = rotate(gameTiles);
        left();
        gameTiles = rotate(gameTiles);
    }

    public void right() {
        saveState(gameTiles);
        gameTiles = rotate(gameTiles);
        gameTiles = rotate(gameTiles);
        left();
        gameTiles = rotate(gameTiles);
        gameTiles = rotate(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        gameTiles = rotate(gameTiles);
        left();
        gameTiles = rotate(gameTiles);
        gameTiles = rotate(gameTiles);
        gameTiles = rotate(gameTiles);
    }

    public boolean canMove() {
        boolean result = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == 0) result = true;
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value || gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    result = true;
                }

            }
        }
        return result;
    }

    public void randomMove() {
        //int randomFunction = new Random().nextInt(4);
        int randomFunction = (int) (Math.random() * 4);

        switch (randomFunction) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
            default:
                break;
        }
    }

    public boolean hasBoardChanged() {
        boolean result = false;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value != previousStates.peek()[i][j].value) {
                    result = true;
                }
            }
        }
        return result;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if(!hasBoardChanged()) return new MoveEfficiency(-1,0,move);
        rollback();

        return moveEfficiency;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(FIELD_WIDTH, Collections.reverseOrder());

        priorityQueue.offer(getMoveEfficiency(() -> left()));
        priorityQueue.offer(getMoveEfficiency(() -> right()));
        priorityQueue.offer(getMoveEfficiency(() -> up()));
        priorityQueue.offer(getMoveEfficiency(() -> down()));
        priorityQueue.peek().getMove().move();
    }
}
