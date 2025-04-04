package DSA.graph;

import java.util.*;
import java.util.stream.Collectors;

public class MyGraph<T> {
    private int noOfVertex;
    private Map<T, List<Edge<T>>> adjacencyList; // hash table :- Vertex -> [connections]

    public MyGraph() {
        this.adjacencyList = new HashMap<>();
    }

    //    {
//        0: [{1, 90}, {2, 80}],
//        1: [{0, 90}],
//        2: [{1, 10}]
//    }
    class Edge<T> {
        T v;
        int weight;

        public Edge(T v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public T getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {
        MyGraph<Integer> graph = new MyGraph<>();
        graph.addVertex(1);
        graph.addVertex(0);
        graph.addVertex(2);
        graph.addVertex(3);
        // Just for test purpose for now, it will either be a directed or bidrection not both
        graph.addEdge(0, 1, 90, false);
        graph.addEdge(0, 2, 80, true);
        graph.addEdge(2, 1, 10, true);
        graph.showConnections();
        System.out.println(graph.noOfVertex);
    }

    private void addVertex(T vertex) {
        // vertex should not exists
        if(this.adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex already exists");
        } else {
            this.adjacencyList.put(vertex, new ArrayList<>());
            this.noOfVertex++;
        }
    }

    private void addEdge(T vertex1, T vertex2, int weight, boolean directed) {
        // check if vertices exists
        // if directed
        // if undirected
        List<Edge<T>> v1Edges = this.adjacencyList.get(vertex1);
        v1Edges.add(new Edge<>(vertex2, weight));
        //this.adjacencyList.put(vertex1, v1Edges);
        if(!directed) {
            List<Edge<T>> v2Edges = this.adjacencyList.get(vertex2);
            v2Edges.add(new Edge<>(vertex1, weight));
        }
    }

    private void showConnections() {
        this.adjacencyList.forEach((k,v) -> {
            System.out.println(k + " -> " + v.stream().map(edge-> "(" +edge.getV() + "," + edge.getWeight() + ")").collect(Collectors.toList()));
        });
    }

}
