import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        DepthFirstSearch dfs = new DepthFirstSearch();

        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(5,2);
        g.removeEdge(3);
        g.removeVertex(3);

        System.out.println(g.getAdjVertices(2));

        System.out.println(g.printGraph());
        Set<Integer> a = dfs.depthFirstTraversal(g,2);
        System.out.println(a);
        for (Integer t: a) {
            System.out.print(t);
        }


    }
}
