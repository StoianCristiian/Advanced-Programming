package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;

public class App {
    public static void main(String[] args)
    {
        Faker faker = new Faker();
        Random random = new Random();
        
        List<Location> locations = new ArrayList<>();
        for(int i=0; i<10 ; ++i)
        {
            LocationType type = LocationType.values()[random.nextInt(3)];
            locations.add(new Location(faker.address().cityName(), type));
        }

        TreeSet<Location> friendlyLocations = locations.stream()
        .filter(loc -> loc.getType() == LocationType.FRIENDLY)
        .collect(Collectors.toCollection(TreeSet::new));

        LinkedList<Location> enemyLocations = locations.stream()
        .filter(loc -> loc.getType() == LocationType.ENEMY)
        .sorted(Comparator.comparing(Location::getType).thenComparing(Location::getName))
        .collect(Collectors.toCollection(LinkedList::new));
            
        System.out.println("Friendly locations:");
        friendlyLocations.forEach(System.out::println);
        System.out.println("\nEnemy locations:");
        enemyLocations.forEach(System.out::println);

        
    }
}
