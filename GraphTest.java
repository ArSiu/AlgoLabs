import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph graph;
    private DepthFirstSearch dfs;

    @Before
    public void init() {
        graph = new Graph();
        dfs = new DepthFirstSearch();
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        graph.addEdge(5,2);
    }

    @Test
    public void testAddVertex() {
        graph.addVertex(6);
        Assert.assertEquals("2[3, 4, 5]3[2]4[2, 5]5[4, 2]6[]", graph.printGraph());
    }

    @Test
    public void testRemoveVertex() {
        graph.removeEdge(3);
        graph.removeVertex(3);
        Assert.assertEquals("2[4, 5]4[2, 5]5[4, 2]", graph.printGraph());
    }

    @Test
    public void testDepthFirstTraversal() {
        Assert.assertEquals("[2, 5, 4, 3]", dfs.depthFirstTraversal(graph, 2).toString());
    }

    @Test
    public void testDepthFirstSearch() {
        Assert.assertTrue(dfs.depthFirstSearch(graph,2,5));
        graph.removeEdge(3);
        graph.removeVertex(3);
        Assert.assertFalse(dfs.depthFirstSearch(graph,3,5));
    }



}
