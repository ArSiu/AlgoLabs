public class Edge {
    private Integer weight = 0;
    private Vertex rightVertex;
    private Vertex leftVertex;

    public Edge(Vertex rightVertex, Vertex leftVertex,Integer weight) {
        this.rightVertex = rightVertex;
        this.leftVertex = leftVertex;
        this.weight = weight;
    }

    public Edge(Vertex rightVertex, Vertex leftVertex) {
        this.rightVertex = rightVertex;
        this.leftVertex = leftVertex;
    }

    public Edge() {}

    public Integer getWeight() {
        return weight;
    }

    public Vertex getRightVertex() {
        return rightVertex;
    }

    public Vertex getLeftVertex() {
        return leftVertex;
    }

    @Override
    public String toString() {
        return " { " + rightVertex + " <--> " + leftVertex + " } ";
    }
}
