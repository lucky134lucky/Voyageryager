package interfaces;

import java.util.Map;
import java.util.Set;

public interface Graph {

    interface Vertex {
        // Получение имени вершины
        String getName();
    }

    interface Edge {
        // Получение веса (длины) дуги
        int getWeight();
    }

    // Получение множества всех вершин
    Set<Vertex> getVertices();

    // Получение множества вершин, соседних с данной
    default Set<Vertex> getNeighbors(Vertex v) {
        return getConnections(v).keySet();
    }

    // Получение по заданной вершине ассоциативного массива,
    // ключом которого я    вляются соседние вершины,
    // а значением -- ведущие в данные вершины дуги
    Map<Vertex, Edge> getConnections(Vertex v);
}
