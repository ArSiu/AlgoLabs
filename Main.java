
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex(new Vertex(2));
        g.addVertex(new Vertex(3));
        g.addVertex(new Vertex(4));
        g.addVertex(new Vertex(5));
        g.addVertex(new Vertex(6));
        g.addEdge(2,3,14);
        g.addEdge(2,4,2);
        g.addEdge(4,5,1);
        g.addEdge(5,2,4);
        g.addEdge(3,6 ,1);
        g.addEdge(5,6 ,5);
        g.removeEdge(3);
        g.removeVertex(3);

//        System.out.println("Get all edges of vertex 2: " + g.getEdges(2));
//        System.out.println("Prints value of vertex and its edges: " + g.printGraph() + " ");
        g.prima();

    }
}
