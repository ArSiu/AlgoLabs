import java.util.*;

public class Graph {
    private Map<Integer, List<Vertex>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<Integer, List<Vertex>>();
    }

    public void addVertex(Integer label) {
        if (adjVertices.get(label) == null) {
            List<Vertex> temp = new ArrayList<>();
            adjVertices.put(label,temp);
        }
    }

    public void removeVertex(Integer label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(label);
    }

    public void addEdge(Integer label1, Integer label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(label1).add(v2);
        adjVertices.get(label2).add(v1);
    }

    public void removeEdge(Integer label1) {
        List<Vertex> eV1 = adjVertices.get(label1);
        if (eV1 != null) {
            for (Vertex v : eV1) {
                adjVertices.get(v.label).removeIf(x -> x.getLable().equals(label1));
            }
        }
    }

    public List<Vertex> getAdjVertices(Integer label) {
        return adjVertices.get(label);
    }

    public String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Integer lable : adjVertices.keySet()) {
            sb.append(lable);
            sb.append(adjVertices.get(lable));
        }
        return sb.toString();
    }

    class Vertex {
        private Integer label;
        public Vertex(Integer label) {
            this.label = label;
        }
        public Integer getLable(){
            return label;
        }

        @Override
        public String toString() {
            return String.valueOf(label);
        }

    }

}
