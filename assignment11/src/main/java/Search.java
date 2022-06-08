import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Search {
    public ArrayList<Integer> breadthFirstSearch(MyGraph graph, Integer v0) {
        Queue<Integer> queue = new Queue<>();

        return searchBase(graph, v0, queue);
    }

    public ArrayList<Integer> depthFirstSearch(MyGraph graph, Integer v0) {
        Stack<Integer> stack = new Stack<>();

        return searchBase(graph, v0, stack);
    }

    private ArrayList<Integer> searchBase(MyGraph graph, Integer v0, Bucket<Integer> foundBucket) {
        LinkedHashSet<Integer> searched = new LinkedHashSet<>();

        foundBucket.add(v0);

        while (foundBucket.size() > 0) {
            Integer v = foundBucket.Pick();
            searched.add(v);

            for (Integer node : graph.getLinkedNodes(v)) {
                if (!searched.contains(node)) {
                    foundBucket.add(node);
                }
            }
        }

        return new ArrayList<Integer>(searched);
    }
}
