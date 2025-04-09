package com.example;

import java.util.ArrayList;
import java.util.List;


public class Bag {
    private final List<Tile> tilesList= new ArrayList<>();

    public Bag(){
        for(char c = 'a'; c <= 'z'; c++)
        {
            for(int i = 0; i < 10; i++)
            {
                tilesList.add(new Tile(c));
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany)
    {
        List<Tile> extracted = new ArrayList<>();
        for(int i = 0 ; i < howMany; i++)
        {
            if(tilesList.isEmpty())
                break;
            else
            {
                int randomIndex = (int) (Math.random()*tilesList.size());
                Tile tile = tilesList.remove(randomIndex);
                extracted.add(tile);
            }
        }
        return extracted;
    }
}
