package pr;


public class FindByDijkstra {

    private static int[][] formGraphToAdjacencyMatrix(Graph graph) {
        int vertex = graph.getCountVertex();
        int[][] adjGraph = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                adjGraph[i][j] = 0;
            }
        }
        for (var edge : graph.getEdges()) {
            adjGraph[edge.getFromVertex() - 1][edge.getToVertex() - 1] = edge.getWeight();
            adjGraph[edge.getFromVertex() - 1][edge.getToVertex() - 1] = edge.getWeight();
        }
        return adjGraph;
    }

    private static int num_Vertices;

    private static int minDistance(int[] path_array, Boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < num_Vertices; v++)
            if (!sptSet[v] && path_array[v] <= min) {
                min = path_array[v];
                min_index = v;
            }

        return min_index;
    }

    private static void printMinpath(int[] path_array) {
        System.out.println("Vertex \t Minimum Distance from Source");
        for (int i = 0; i < num_Vertices; i++)
            System.out.println((i + 1) + " \t\t\t " + path_array[i]);
    }

    public static void getPaths(Graph graph) {
        int src_node = 0;
        num_Vertices = graph.getCountVertex();
        var adjGraph = formGraphToAdjacencyMatrix(graph);

        int[] path_array = new int[num_Vertices];

        Boolean[] sptSet = new Boolean[num_Vertices];

        for (int i = 0; i < num_Vertices; i++) {
            path_array[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        path_array[src_node] = 0;
        for (int count = 0; count < num_Vertices - 1; count++) {
            int u = minDistance(path_array, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < num_Vertices; v++)

                if (!sptSet[v] && adjGraph[u][v] != 0 && path_array[u] !=
                        Integer.MAX_VALUE && path_array[u]
                        + adjGraph[u][v] < path_array[v])
                    path_array[v] = path_array[u] + adjGraph[u][v];
        }

        printMinpath(path_array);
    }
}
