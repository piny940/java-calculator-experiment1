import java.util.LinkedList;

public class MyList {
    public void insert(int x, LinkedList<Integer> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            Integer el = linkedList.get(i);
            if (el >= x) {
                linkedList.add(i, el);
                break;
            }
        }
    }

    public void delete(int x, LinkedList<Integer> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i) == x) {
                linkedList.remove(i);
            }
        }
    }

    public void output(LinkedList<Integer> linkedList) {
        String output = "";
        for (int i = 0; i < linkedList.size(); i++) {
            output += linkedList.get(i);
            if (i == linkedList.size() - 1) {
                output += "\n";
            } else {
                output += " ";
            }
        }

        System.out.println(output);
    }
}
