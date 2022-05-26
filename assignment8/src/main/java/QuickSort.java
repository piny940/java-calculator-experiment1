import java.util.ArrayList;

public class QuickSort {
    public static void sort(ArrayList<Integer> list) {
        
    }

    public static void swap(ArrayList<Integer> list, Integer i, Integer j) {
        Integer x = list.get(i);
        list.set(i, list.get(j));
        list.set(j, x);
    }
}
