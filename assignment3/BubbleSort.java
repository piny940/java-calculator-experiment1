import java.util.ArrayList;

public class BubbleSort {
    public static void sort(ArrayList<Integer> arrayList) {
        for (Integer i = arrayList.size(); i >= 2; i--) {
            for (Integer j = 0; j < i-1; j++) {
                if (arrayList.get(j) > arrayList.get(j+1)) {
                    Integer tmp = arrayList.get(j+1);
                    arrayList.set(j+1, arrayList.get(j));
                    arrayList.set(j, tmp);
                }
            }
        }
    }
}
