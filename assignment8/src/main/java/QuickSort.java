import java.util.ArrayList;

public class QuickSort {
    public static void sort(ArrayList<Integer> list) {
        partSort(list, 0, list.size());
    }

    public static void partSort(ArrayList<Integer> list, int startIdx, int endIdx) {
        if (endIdx - startIdx <= 1) {
            return;
        }

        int pivot = getPivot(list, startIdx, endIdx);
        Integer pivotValue = list.get(pivot);
        for (int i = startIdx; i < endIdx; i++) {
            if (list.get(i) < pivotValue) {
                Integer value = list.get(i);
                list.remove(i);
                list.add(pivot, value);
                pivot++;
            }
        }
        partSort(list, startIdx, pivot);
        partSort(list, pivot+1, endIdx);
    }

    public static int getPivot(ArrayList<Integer> list, int startIdx, int endIdx) {
        return startIdx;
    }
}
