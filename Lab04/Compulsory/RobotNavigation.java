import java.util.*;
import java.util.stream.Collectors;

public class RobotNavigation
{
    public static void main(String[] args)
    {
        List<Location> locations = Arrays.asList(
            new Location("A", LocationType.FRIENDLY),
            new Location("B", LocationType.ENEMY),
            new Location("C", LocationType.NEUTRAL),
            new Location("D", LocationType.FRIENDLY),
            new Location("E", LocationType.ENEMY),
            new Location("F", LocationType.FRIENDLY)
        );

        TreeSet<Location> friendlyLocations = locations.stream()
        .filter(loc -> loc.getType() == LocationType.FRIENDLY)
        .collect(Collectors.toCollection(TreeSet::new));

        LinkedList<Location> enemyLocations = locations.stream()
            .filter(loc -> loc.getType() == LocationType.ENEMY)
            .collect(Collectors.toCollection(LinkedList::new));
            
        System.out.println("Friendly locations:");
        friendlyLocations.forEach(System.out::println);
        System.out.println("\nEnemy locations:");
        enemyLocations.forEach(System.out::println);
    }
}