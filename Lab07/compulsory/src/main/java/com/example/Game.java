package com.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

    public void play(){
        List<Thread> threads = new ArrayList<>();

        for(Player player : players)
        {
            Thread thread = new Thread(player);
            threads.add(thread);
            thread.start();
        }

        for(Thread thread : threads)
        {
            try{
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        game.addPlayer(new Player("player 1"));
        game.addPlayer(new Player("player 2"));
        game.addPlayer(new Player("player 3"));
        game.play();
    }
}