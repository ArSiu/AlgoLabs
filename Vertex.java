public class Vertex {
    private int value;

    public Vertex(int value) {
        this.value = value;
    }

    public Vertex() {
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
