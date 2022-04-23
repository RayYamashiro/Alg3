package pr;

public class Edge implements Comparable<Edge> {
    private int fromVertex;
    private int toVertex;
    private int weight;

    public Edge(int from, int to, int weight){
        fromVertex = from;
        toVertex = to;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge edge) {
        if (weight != edge.getWeight()){
            return weight < edge.weight ? -1 : 1;
        }
        return 0;
    }

    public int getFromVertex() {
        return fromVertex;
    }

    public void setFromVertex(int fromVertex) {
        this.fromVertex = fromVertex;
    }

    public int getToVertex() {
        return toVertex;
    }

    public void setToVertex(int toVertex) {
        this.toVertex = toVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  "from=" + fromVertex +
                ", to=" + toVertex +
                ", weight=" + weight;
    }

}
