import java.util.ArrayList;

public class MergeSort {
    public static void sort(ArrayList<String> arrayList) {
        partSort(arrayList, 0, arrayList.size());
    }

    public static void partSort(ArrayList<String> list, int startIdx, int endIdx) {
        if (endIdx - startIdx <= 1) {
            return;
        }
        int size = endIdx - startIdx;
        partSort(list, startIdx, startIdx + size/2);
        partSort(list, startIdx + size / 2, endIdx);
        merge(list, startIdx, endIdx);
    }

    public static void merge(ArrayList<String> list, int startIdx, int endIdx) {
        int size = endIdx - startIdx;
        int formerIdx = startIdx;
        int latterIdx = startIdx + size/2;
        while (formerIdx < latterIdx && latterIdx < endIdx) {
            if (list.get(formerIdx).compareTo(list.get(latterIdx)) > 0) {
                String latterValue = list.get(latterIdx);
                list.remove(latterIdx);
                list.add(formerIdx, latterValue);
                latterIdx++;
            }
            formerIdx++;
        }
    }
}
