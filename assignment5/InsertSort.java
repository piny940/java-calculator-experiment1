import java.util.ArrayList;

public class InsertSort {
    public static void sort(ArrayList<Integer> list) {
        ArrayList<Integer> copiedList = new ArrayList<Integer>(list);
        list.clear();

        for (Integer i = 0; i < copiedList.size(); i++) {
            Integer value = copiedList.get(i);

            Boolean added = false;
            for (Integer j = 0; j < list.size(); j++) {
                if (value <= list.get(j)) {
                    list.add(j, value);
                    added = true;
                    break;
                }
            }
            
            if (!added) {
                list.add(value);
            }
        }
    }
}
