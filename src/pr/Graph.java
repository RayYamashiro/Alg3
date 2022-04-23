package pr;


import java.util.ArrayList;
import java.util.Collections;

public class Graph {
    private ArrayList<Edge> edges;
    private int weight;

    public Graph(ArrayList<Edge> edges){
        this.edges = edges;
        Collections.sort(edges);
        for(var edge : edges){
            weight += edge.getWeight();
        }
    }

    public int getCountVertex(){
        int count = 0;
        for (Edge edge : edges) {
            if (count < edge.getFromVertex()) {
                count = edge.getFromVertex();
            }
            if (count < edge.getToVertex()) {
                count = edge.getToVertex();
            }
        }
        return count;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        String backEdges = "";
        for (var edge : edges){
            backEdges += edge.toString() + "\n";
        }
        return "Graph:\n" +
                "edges=\n" + backEdges +
                "weight=" + weight;
    }
}