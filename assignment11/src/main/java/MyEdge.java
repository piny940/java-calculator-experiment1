public class MyEdge {
    private Integer node1;
    private Integer node2;
    private Integer weight;

    public MyEdge(Integer node1, Integer node2, Integer weight) {
        this.node1 = Math.min(node1, node2);
        this.node2 = Math.max(node1, node2);
        this.weight = weight;
    }

    public Integer[] getNodes() {
        Integer[] nodes = { this.node1, this.node2 };
        return nodes;
    }

    public Integer getWeight() {
        return this.weight;
    }
}
