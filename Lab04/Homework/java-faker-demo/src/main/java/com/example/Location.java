package com.example;

class Location implements Comparable<Location>
{
    private final String name;
    private final LocationType type;

    public Location(String name, LocationType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public LocationType getType() { return type; }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString()
    {
        return name + " (" + type + ")";
    }
}