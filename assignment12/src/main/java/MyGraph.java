import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MyGraph {
    private final int MAX_NODES_NUM = 50;
    private final int MAX_EDGES_NUM = 100;
    private final Integer MAX_WEIGHT = 9999;
    private final Integer MIN_WEIGHT = 1;

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

    private Integer getWeight(Integer v, Integer w) {
        LinkedList<MyEdge> edges = this.getEdges(v);
        for (MyEdge edge : edges) {
            if (Arrays.asList(edge.getNodes()).contains(w)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("The vertices v and w are not connected.");
    }

    private int size() {
        return this.edges.length;
    }

    public Integer[] explore(Integer start, Integer end) {
        Integer[] distances = new Integer[this.size()];
        Integer[] prevs = new Integer[this.size()];
        ArrayList<Integer> found = new ArrayList<>();

        distances[start] = 0;
        found.add(start);
        
        while (true) {
            if (found.size() == 0) {
                throw new RuntimeException("The end point is not connected to the start point.");
            }

            // Find the vertex in the found list that has the smallest distance from the
            // starting point.
            Integer minNode = found.get(0);
            Integer minDistance = distances[minNode];
            for (Integer node : found) {
                if (distances[node] < minDistance) {
                    minNode = node;
                    minDistance = distances[node];
                }
            }

            if (minNode == end) {
                return prevs;
            }

            found.remove(minNode);
            for (Integer el : this.getLinkedNodes(minNode)) {
                if (distances[el] == null) {
                    distances[el] = minDistance + this.getWeight(minNode, el);
                    prevs[el] = minNode;
                    found.add(el);
                }
                else if (distances[el] > distances[minNode] + this.getWeight(el, minNode)) {
                    distances[el] = minDistance + this.getWeight(minNode, el);
                    prevs[el] = minNode;
                }
            }
        }
    }
}