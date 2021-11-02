import java.lang.reflect.Array;
import java.util.*;

public class Graph {
    private Map<Vertex, List<Edge>> adjVertices;
    private int minVertex;
    private int maxVertex;
    public int graphSize;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public Map<Vertex, List<Edge>> getAdjVertices() {
        return adjVertices;
    }

    public List<Edge> getEdges(int vertex) {
        Vertex[] vertexes = iterator(vertex,0);
        if(vertexes == null || vertexes[0] == null ){
            return null;
        }

        return adjVertices.get(vertexes[0]);
    }

    public void addVertex(Vertex vertex) {
        if (adjVertices.get(vertex) == null) {
            graphSize++;
            if(vertex.getValue() > maxVertex){
                maxVertex = vertex.getValue();
            } else if(vertex.getValue() < minVertex){
                minVertex = vertex.getValue();
            }
            List<Edge> list = new ArrayList<>();
            adjVertices.putIfAbsent(vertex,list);
        }
    }

    public void addEdge(int vertexRight, int vertexLeft){
        Vertex[] vertexes = iterator(vertexRight,vertexLeft);
        if(vertexes == null || vertexes[0] == null || vertexes[1] == null){
            return;
        }
        Edge edge = new Edge(vertexes[0],vertexes[1]);
        adjVertices.get(vertexes[0]).add(edge);
        adjVertices.get(vertexes[1]).add(edge);
    }

    public void addEdge(int vertexRight, int vertexLeft, Integer weight){
        Vertex[] vertexes = iterator(vertexRight,vertexLeft);
        if(vertexes == null || vertexes[0] == null || vertexes[1] == null){
            return;
        }
        Edge edge = new Edge(vertexes[0],vertexes[1],weight);
        adjVertices.get(vertexes[0]).add(edge);
        adjVertices.get(vertexes[1]).add(edge);
    }

    public void removeVertex(int vertex) {
        Vertex[] vertexes = iterator(vertex,0);
        if(vertexes == null || vertexes[0] == null){
            return;
        }
        adjVertices.remove(vertexes[0]);
    }

    public void removeEdge(int value) {
        Vertex[] vertexes = iterator(value,0);
        if(vertexes == null || vertexes[0] == null ){
            return;
        }
        for (Vertex vertex:adjVertices.keySet()) {
            List<Edge> t = adjVertices.get(vertex);
            if(t!=null){
                t.removeIf(e -> e.getRightVertex().equals(vertexes[0]) || e.getLeftVertex().equals(vertexes[0]));
            }
        }
    }

    public String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Vertex vertex : adjVertices.keySet()) {
            sb.append(vertex+"=");
            sb.append(adjVertices.get(vertex)+" ");
        }
        return sb.toString();
    }

    private Vertex[] iterator(int vertexRight, int vertexLeft) {
        Vertex[] vertexes = new Vertex[2];
        vertexes[0] = null;
        vertexes[1] = null;
        for (Vertex v : adjVertices.keySet()) {
            if(vertexRight == v.getValue()){
                vertexes[0] = v;
            } else if(vertexLeft == v.getValue()){
                vertexes[1] = v;
            }
        }
        return vertexes;
    }

    public void prima(){
        List<Edge> preEdge = new ArrayList<>();
        List<Vertex> preVertex = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        for (Vertex vertex : adjVertices.keySet()) {
            for (Edge edge:adjVertices.get(vertex)) {
                if(!edges.contains(edge)){
                    edges.add(edge);
                }
            }

        }
        edges.sort((edge1, edge2) -> edge1.getWeight().compareTo(edge2.getWeight()));

        preVertex.add(edges.get(0).getRightVertex());
        preVertex.add(edges.get(0).getLeftVertex());
        preEdge.add(edges.get(0));
        edges.remove(edges.get(0));

        int i = 0;
        while (i != edges.size()){
            Edge current = edges.get(i);
            Vertex left = current.getLeftVertex();
            Vertex right = current.getRightVertex();
            if(preVertex.contains(left) && !preVertex.contains(right)){
                preVertex.add(right);
                preEdge.add(current);
                edges.remove(current);
                i=0;
                continue;
            }
            if(!preVertex.contains(left) && preVertex.contains(right)){
                preVertex.add(left);
                preEdge.add(current);
                edges.remove(current);
                i=0;
                continue;
            }
            i++;
        }
        int res = 0;
        for (Edge e:preEdge) {
            res+=e.getWeight();
        }
        System.out.println("RRRRR "+res);
        long a = 69420;
        long b = 42068;
        System.out.println(b - b % a / 2);


    }
}
