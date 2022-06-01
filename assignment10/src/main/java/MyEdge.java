import java.util.Objects;

public class MyEdge {
    private Integer node1;
    private Integer node2;
    private Integer weight;

    public MyEdge(Integer node1, Integer node2, Integer weight) {
        this.node1 = Math.min(node1, node2);
        this.node2 = Math.max(node1, node2);
        this.weight = weight;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (!(object instanceof MyEdge)) {
            return false;
        }

        MyEdge edge = (MyEdge)object;

        return this.node1 == edge.node1
                && this.node2 == edge.node2
                && this.weight == edge.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.node1, this.node2, this.weight);
    }

    public Integer[] getNodes() {
        Integer[] nodes = { this.node1, this.node2 };
        return nodes;
    }

    public Integer getWeight() {
        return this.weight;
    }
}
