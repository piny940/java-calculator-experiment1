import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyGraphTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();
            int id = Integer.parseInt(scanner.nextLine());
            scanner.close();

            MyGraph myGraph = new MyGraph();
            myGraph.readFromFile(filename);
            LinkedList<MyEdge> linkedEdges = myGraph.getEdges(id);

            for (MyEdge edge : linkedEdges) {
                Integer[] nodes = edge.getNodes();
                Integer node = nodes[0] != id ? nodes[0] : nodes[1];
                Integer weight = edge.getWeight();

                System.out.println(String.format("%d %d", node, weight));
            }
        }
        catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
