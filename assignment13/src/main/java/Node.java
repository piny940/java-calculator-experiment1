public class Node implements Comparable<Node> {
    Integer id;
    Integer distance;

    public Node(Integer id, Integer distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node node) {
        return this.distance - node.distance;
    }
}
