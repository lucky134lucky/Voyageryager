package classes;

import interfaces.Graph;

public class City implements Graph.Vertex {
    private String cityName;

    //Конструктор для города
    public City(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String getName() {
        return cityName;
    }

    @Override
    public String toString() {
        return cityName;
    }

    @Override
    protected Object clone() {
        return new City(cityName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof City)
            return ((City) obj).cityName.equals(this.cityName);
        else
            return false;
    }
}
