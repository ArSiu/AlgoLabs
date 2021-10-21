import javax.swing.*;
import java.util.*;

public class DepthFirstSearch {
    // explores vertex as deeper as can before hitting vertex at the same level
    public Set<Integer> depthFirstTraversal(Graph graph, Integer root) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                if(graph.getAdjVertices(vertex)!= null){
                    for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                        stack.push(v.getLable());
                    }
                } else {
                    return null;
                }
            }
        }
        return visited;
    }
    // explores vertex as deeper as can before hitting the goal vertex
    public Boolean depthFirstSearch(Graph graph, Integer goal, Integer start) {
        int maxValue = 0;
        for (Map.Entry<Integer, List<Graph.Vertex>> entry : graph.getAdjVertices().entrySet()) {
            if(maxValue<entry.getKey()){
                maxValue=entry.getKey();
            }
            for (Graph.Vertex vertex : entry.getValue()) {
                if (vertex.getLable() > maxValue)
                    maxValue = vertex.getLable();
            }
        }
        boolean[] visited = new boolean[maxValue+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            if (vertex.equals(goal)) {
                return true;
            }
            for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                if(visited[v.getLable()] == false) {
                    stack.push(v.getLable());
                    visited[v.getLable()] = true;
                }
            }
        }
        return false;
    }


}
