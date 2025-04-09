package com.example;

import static java.lang.Thread.sleep;
import java.util.List;
import java.util.stream.Collectors;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;

    public Player(String name)
    {
        this.name = name;
    }

    private boolean submitWord(){
        List<Tile> extracted = game.getBag().extractTiles(7);
        if(extracted.isEmpty())
            return false;
        String word = extracted.stream().map(tile -> String.valueOf(tile.getLetter())).collect(Collectors.joining());
        if(game.getDictionary().isWord(word)) {
            game.getBoard().addWord(this, word);
        }
        try{
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while(submitWord()){}
    }
}