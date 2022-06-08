import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();
            int v0 = Integer.parseInt(scanner.nextLine());
            scanner.close();

            MyGraph graph = new MyGraph();
            graph.readFromFile(filename);
            
            Search search = new Search();
            ArrayList<Integer> depthSearchResult = search.depthFirstSearch(graph, v0);
            ArrayList<Integer> breadthSearchResult = search.breadthFirstSearch(graph, v0);

            System.out.println("---- DepthFirstSearch ----");
            for (Integer el : depthSearchResult) {
                System.out.println(el);
            }

            System.out.println("---- BreadthSearchResult ----");
            for (Integer el : breadthSearchResult) {
                System.out.println(el);
            }
        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
