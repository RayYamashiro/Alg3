package pr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FinderByDynamic {
    private static final HashMap<Integer, Integer> pathToVertex = new HashMap<>();

    public static ArrayList<Integer> findTheShortestPath(Graph graph){
        getLenMinPath(graph);
        ArrayList<Integer> path = getThisPath(graph);
        Collections.reverse(path);
        path.add(graph.getCountVertex());
        path.add(pathToVertex.get(graph.getCountVertex()));
        return path;
    }

    private static ArrayList<Integer> getThisPath(Graph graph){
        ArrayList<Integer> path = new ArrayList<>();
        for (int vertex = graph.getCountVertex(); vertex > 1; vertex--){
            for(var edge : graph.getEdges()){
                boolean exit = false;
                if (edge.getToVertex() == vertex){
                    for(int iteratorInPathToVertex = 1; iteratorInPathToVertex < graph.getCountVertex(); iteratorInPathToVertex++)
                        if(pathToVertex.get(vertex) - pathToVertex.get(vertex-iteratorInPathToVertex) == edge.getWeight()){
                            path.add(edge.getFromVertex());
                            vertex = edge.getFromVertex() + 1;
                            exit = true;
                            break;
                        }
                }
                if(exit)
                    break;
            }
        }
        return path;
    }

    private static void getLenMinPath(Graph graph){
        for(var edge : graph.getEdges()){
            if(edge.getFromVertex() == 1){
                pathToVertex.put(1, 0);
            }
        }
        for(int vertex = 2; vertex <= graph.getCountVertex(); vertex++){
            ArrayList<Integer> paths = new ArrayList<>();
            for(var edge : graph.getEdges()){
                if(edge.getToVertex() == vertex){
                    paths.add(pathToVertex.get(edge.getFromVertex()) + edge.getWeight());
                }
            }
            int shortestPath = 999999;
            for(var path : paths){
                if (shortestPath > path){
                    shortestPath = path;
                }
            }
            pathToVertex.put(vertex, shortestPath);
        }
    }
}
