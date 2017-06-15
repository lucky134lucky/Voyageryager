package classes;


import interfaces.Graph.Vertex;

import java.util.ArrayList;
import java.util.Set;

public class Iskatel {
    private static final boolean FULL_DEBUG = true;

    public static final int NOT_FOUND = -3;

    private static Way currentOptimalWay = new Way(Integer.MAX_VALUE);

    private static ArrayList<Vertex> findOptimalWay(Towns t, Vertex currentTown, Way way, Vertex start) {

        Set<Vertex> neighborsSet = t.getNeighbors(currentTown);
        Vertex[] neighbors = neighborsSet.toArray(new Vertex[neighborsSet.size()]);

        ArrayList<Vertex> alreadyWas = way.getPath();

        if (FULL_DEBUG) {
            System.out.println("Path = " + alreadyWas.toString());
            System.out.println("Current city = " + currentTown.getName());
        }

        alreadyWas.add(currentTown);

        for (Vertex neighbor : neighbors) {
            if (FULL_DEBUG)
                System.out.println("Current neighbour " + neighbor.getName());


            if (!alreadyWas.contains(neighbor)) {
                if (FULL_DEBUG) {
                    System.out.println("Never was in " + neighbor.getName());
                    System.out.println("Going to " + neighbor.getName());
                    System.out.print("Path to = " + t.getLength(currentTown, neighbor));
                }
                way.addLength(t.getLength(currentTown, neighbor));

                ArrayList<Vertex> path = findOptimalWay(t, neighbor, way, start);


                if (path != null) {
                    return path;
                } else {
                    if (FULL_DEBUG)
                        System.out.println("Removing from path " + neighbor.getName());

                    if (alreadyWas.size() == t.getVertices().size() && t.getLength(neighbor, start) != NOT_FOUND) {
                        System.out.println(way.getPath());
                        way.addLength(t.getLength(neighbor, start));
                        System.out.println("Found one way, length = " + way.getLength() + " " + alreadyWas.toString());

                        if (currentOptimalWay.getLength() > way.getLength())
                            currentOptimalWay = (Way) way.clone();
                        way.removeLength(t.getLength(neighbor, start));
                    }

                    way.removeLength(t.getLength(currentTown, neighbor));
                    alreadyWas.remove(neighbor);
                }
            } else if (FULL_DEBUG)
                System.out.println("Already was in " + neighbor.getName());
        }
        System.out.println("Optimal way + " + currentOptimalWay.getPath().toString());
        return null;
    }

    public static ArrayList<Vertex> findShortestLoop(Towns t) {
        currentOptimalWay = new Way(Integer.MAX_VALUE);
        findOptimalWay(t, t.getTown(0), new Way(), t.getTown(0));
        return currentOptimalWay.getPath();
    }
}