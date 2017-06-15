package classes;

import interfaces.Graph;

import java.util.*;

import static classes.Iskatel.NOT_FOUND;

public class Towns implements Graph {

    Set<City> cities = new HashSet<>();
    HashSet<Road> roads = new HashSet<>();

    public void addTown(City townName) {
        this.cities.add(townName);
    }

    public void addRoad(Vertex firstTown, Vertex secondTown, int roaddLength) {
        this.roads.add(new Road(firstTown, secondTown, roaddLength));
    }

    public Vertex getTown(int i) {
        Vertex[] neighbors = cities.toArray(new Vertex[cities.size()]);
        return neighbors[i];
    }

    public int getLength(Vertex a, Vertex b) {
        System.out.println("Near " + a.getName() + " near " + b.getName());
        Edge road = getConnections(a).get(b);

        if (road != null)
            return road.getWeight();
        else
            return NOT_FOUND;
    }

    //Возвращает все города
    @Override
    public Set<Vertex> getVertices() {
        HashSet<Vertex> v = new HashSet<>();
        v.addAll(cities);
        return v;
    }

    //Возвращает всех соседей заданного города
    @Override
    public Set<Vertex> getNeighbors(Vertex v) {
        HashSet<Vertex> neighbors = new HashSet<>();
        for (Road road : roads) {
            Vertex nextCityName = null;
            if (road.consistCity(v))
                nextCityName = road.nextCity(v);

            for (City city : cities) {
                if (city.equals(nextCityName)) neighbors.add(city);
            }
        }
        return neighbors;
    }

    //Возвращает Map с вершиной и ребрами
    @Override
    public Map<Vertex, Edge> getConnections(Vertex v) {
        HashMap<Vertex, Edge> connections = new HashMap<>();

        for (Road road : roads) {
            if (road.consistCity(v)) {
                connections.put(road.nextCity(v), road);
            }
        }
        return connections;
    }

}
