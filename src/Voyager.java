import classes.City;
import classes.Towns;
import interfaces.Graph;

import java.util.ArrayList;
import java.util.Set;

import static classes.Iskatel.findShortestLoop;


public class Voyager {

    public static void main(String args[]) {
        System.out.println("Start of the Voyager program");

        //Создаю экземпляр класса города, в котором будут храниться данные о городах и расстояних между ними
        Towns towns = new Towns();

        //создаю города, к которым буду прокладывать дороги
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");
        City g = new City("G");

        //Добавляю данные, а именно все города
        towns.addTown(a);
        towns.addTown(b);
        towns.addTown(c);
        towns.addTown(d);
        towns.addTown(e);
        towns.addTown(f);
        towns.addTown(g);


        //Добавляю данные, а именно все дороги
        towns.addRoad(a, b, 100);
        towns.addRoad(b, d, 60);
        towns.addRoad(b, f, 150);
        towns.addRoad(d, f, 70);
        towns.addRoad(f, g, 120);
        towns.addRoad(a, g, 300);
        towns.addRoad(g, c, 280);
        towns.addRoad(g, e, 100);
        towns.addRoad(c, e, 100);
        towns.addRoad(c, a, 100);


        //Проверяю как работает метод получения всех городов, вывожу список
        Set<Graph.Vertex> testCities = towns.getVertices();
        System.out.println("Введенные города:");
        for (Graph.Vertex vertex : testCities) {
            System.out.println(vertex.getName());
        }

        //Класс way будет содержать кратчайший путь
        ArrayList<Graph.Vertex> path = new ArrayList<>();

        path = findShortestLoop(towns);

        towns.getLength(a, b);
        // Выводим кратчайший путь
        System.out.print("Path: ");
        for (Graph.Vertex current : path) {
            System.out.print("" + current.getName());
        }

    }
}
