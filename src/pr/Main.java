package pr;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        showDynamic();
        showDijkstra();
    }

    private static void showDynamic(){
        Graph graph = createGraphFor16Dynamic();
        System.out.println(graph);
        var path = FinderByDynamic.findTheShortestPath(graph);
        System.out.println("\nDynamic algorithm");
        System.out.print("Path: ");
        for(var vertex : path){
            if (vertex > graph.getCountVertex()){
                System.out.print("\nWeight - " + vertex);
            } else {
                System.out.print(vertex + " ");
            }
        }
    }

    private static void showDijkstra() {
        Graph graph = createGraphFor16Dijkstra();
        System.out.println("\n----------------------------\n" + graph);
        System.out.println("\nDijkstra algorithm");
        FindByDijkstra.getPaths(graph);

    }

    private static Graph createGraphFor16Dynamic() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 4, 8));
        edges.add(new Edge(1, 5, 25));
        edges.add(new Edge(1, 7, 20));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(2, 7, 15));
        edges.add(new Edge(3, 6, 3));
        edges.add(new Edge(4, 5, 9));
        edges.add(new Edge(5, 7, 6));
        edges.add(new Edge(6, 7, 4));
        return new Graph(edges);
    }

    private static Graph createGraphFor16Dijkstra() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2, 18));
        edges.add(new Edge(1, 8, 22));
        edges.add(new Edge(1, 7, 9));
        edges.add(new Edge(1, 4, 4));
        edges.add(new Edge(2, 3, 1));
        edges.add(new Edge(2, 5, 3));
        edges.add(new Edge(2, 8, 1));
        edges.add(new Edge(3, 5, 13));
        edges.add(new Edge(4, 6, 5));
        edges.add(new Edge(4, 7, 7));
        edges.add(new Edge(5, 8, 9));
        edges.add(new Edge(5, 7, 2));
        edges.add(new Edge(6, 7, 5));
        edges.add(new Edge(7, 8, 10));
        return new Graph(edges);
    }
}
