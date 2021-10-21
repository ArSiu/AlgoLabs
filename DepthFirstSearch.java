import java.util.*;

public class DepthFirstSearch {
    public Set<Integer> depthFirstTraversal(Graph graph, Integer root) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.getLable());
                }
            }
        }
        return visited;
    }

    public Set<Integer> breadthFirstTraversal(Graph graph, Integer root) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.getLable())) {
                    visited.add(v.getLable());
                    queue.add(v.getLable());
                }
            }
        }
        return visited;
    }
}
