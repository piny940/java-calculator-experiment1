import java.util.ArrayList;

public class MergeSort {
    public static void sort(ArrayList<Integer> arrayList) {
        partSort(arrayList, 0, arrayList.size());
    }

    public static void partSort(ArrayList<Integer> list, Integer startIdx, Integer endIdx) {
        if (endIdx - startIdx <= 1) {
            return;
        }
        Integer size = endIdx - startIdx;
        partSort(list, startIdx, startIdx + size/2);
        partSort(list, startIdx + size / 2, endIdx);
        merge(list, startIdx, endIdx);
    }

    public static void merge(ArrayList<Integer> list, Integer startIdx, Integer endIdx) {
        Integer size = endIdx - startIdx;
        int formerIdx = startIdx;
        int latterIdx = startIdx + size/2;
        while (formerIdx < latterIdx && latterIdx < endIdx) {
            if (list.get(formerIdx) > list.get(latterIdx)) {
                Integer latterValue = list.get(latterIdx);
                list.remove(latterIdx);
                list.add(formerIdx, latterValue);
                latterIdx++;
            }
            formerIdx++;
        }
    }
}
