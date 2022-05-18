import java.util.ArrayList;

public class InsertSort {
    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            Integer value = list.get(i);
            list.remove(i);

            Boolean added = false;
            for (int j = 0; j < i; j++) {
                if (value <= list.get(j)) {
                    list.add(j, value);
                    added = true;
                    break;
                }
            }
            
            if (!added) {
                list.add(i, value);
            }
        }
    }
}
