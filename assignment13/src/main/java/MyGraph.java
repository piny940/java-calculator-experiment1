import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MyGraph {
    private final int MAX_NODES_NUM = Integer.MAX_VALUE;
    private final int MAX_EDGES_NUM = Integer.MAX_VALUE;
    private final Integer MAX_WEIGHT = Integer.MAX_VALUE;
    private final Integer MIN_WEIGHT = 0;

    private LinkedList<MyEdge>[] edges;

    public void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int nodeNum = Integer.parseInt(scanner.nextLine());
            int edgeNum = Integer.parseInt(scanner.nextLine());

            if (nodeNum > MAX_NODES_NUM) {
                String message = String.format(
                    "The number of nodes must be less than %d.",
                    MAX_NODES_NUM
                );
                scanner.close();
                throw new RuntimeException(message);
            }
            if (edgeNum > MAX_EDGES_NUM) {
                String message = String.format(
                        "The number of edges must be less than %d.",
                        MAX_EDGES_NUM);
                scanner.close();
                throw new RuntimeException(message);
            }

            this.edges = new LinkedList[nodeNum];

            for (int i = 0; i < nodeNum; i++) {
                this.edges[i] = new LinkedList<MyEdge>();
            }
            for (int i = 0; i < edgeNum; i++) {
                String[] chars = scanner.nextLine().split(" ");
                Integer[] nums = new Integer[chars.length];

                for (int j = 0; j < chars.length; j++) {
                    nums[j] = Integer.parseInt(chars[j]);
                }

                if (nums[2] > MAX_WEIGHT || nums[2] < MIN_WEIGHT) {
                    String message = String.format(
                        "The weight value must be between %d and %d.",
                        MIN_WEIGHT, MAX_WEIGHT
                    );
                    scanner.close();
                    throw new RuntimeException(message);
                }

                this.edges[nums[0]].add(new MyEdge(nums[0], nums[1], nums[2]));
                this.edges[nums[1]].add(new MyEdge(nums[0], nums[1], nums[2]));
            }

            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            System.exit(0);
        }
        catch (NumberFormatException ex) {
            System.out.println("Input must be an integer value.");
            System.exit(0);
        }
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    public LinkedList<MyEdge> getEdges(int id) {
        return this.edges[id];
    }

    private Integer[] getLinkedNodes(int id) {
        LinkedList<MyEdge> edges = this.getEdges(id);
        Integer[] nodes = new Integer[edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            Integer[] ends = edges.get(i).getNodes();
            nodes[i] = ends[0] == id ? ends[1] : ends[0];
        }

        return nodes;
    }

    public Integer getWeight(Integer v, Integer w) {
        LinkedList<MyEdge> edges = this.getEdges(v);
        for (MyEdge edge : edges) {
            if (Arrays.asList(edge.getNodes()).contains(w)) {
                return edge.getWeight();
            }
        }
        String message = String.format("The vertices %s and %s are not connected.", v, w);
        throw new RuntimeException(message);
    }

    private int getNodeSize() {
        return this.edges.length;
    }

    public Integer[] getShortestPath(Integer start, Integer end) {
        int size = this.getNodeSize();
        boolean[] determined = new boolean[size];
        Integer[] distances = new Integer[size];
        Integer[] prevs = new Integer[size];

        PriorityQueue<Node> found = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;

        found.add(new Node(start, 0));

        while (true) {
            if (found.size() == 0) {
                break;
            }

            Node node = found.poll();
            int minId = node.id;
            
            if (determined[minId]) {
                continue;
            }
            determined[minId] = true;

            for (int nextId : this.getLinkedNodes(minId)) {
                if (distances[nextId] > distances[minId] + this.getWeight(minId, nextId)) {
                    distances[nextId] = distances[minId] + this.getWeight(minId, nextId);
                    found.add(new Node(nextId, distances[nextId]));
                    prevs[nextId] = minId;
                }
            }
        }

        return prevs;
    }
}
