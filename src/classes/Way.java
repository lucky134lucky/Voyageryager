package classes;


import interfaces.Graph;
import interfaces.Graph.Vertex;

import java.util.ArrayList;

public class Way {
    ArrayList<Vertex> path;
    int length;

    public Way() {
        path = new ArrayList<>();
    }

    public Way(int length) {
        this.length = length;
        path = new ArrayList<>();
    }

    public Way(ArrayList<Vertex> cities, int length) {
        this.length = length;
        path = cities;
    }

    public ArrayList<Vertex> getPath() {
        return path;
    }

    public void setPath(ArrayList<Vertex> path) {
        this.path = path;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void addLength(int distance) {
        length += distance;
    }

    public void removeLength(int distance) {
        length -= distance;
    }

    @Override
    protected Object clone() {
        return new Way(new ArrayList<>(path), length);
    }
}
