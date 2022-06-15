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
        int formerIdx = 0;
        int latterIdx = size / 2;
        int current = startIdx;
        Integer[] tmpArr = new Integer[size];

        for (int i = 0; i < size; i++) {
            tmpArr[i] = list.get(startIdx + i);
        }

        while (formerIdx < size / 2 && latterIdx < size) {
            if (tmpArr[formerIdx] > tmpArr[latterIdx]) {
                list.set(current, tmpArr[latterIdx]);
                latterIdx++;
            }
            else {
                list.set(current, tmpArr[formerIdx]);
                formerIdx++;
            }
            current++;
        }

        int remaining = size / 2 - formerIdx;
        for (int i = 0; i < remaining; i++) {
            list.set(current + i, tmpArr[formerIdx + i]);
        }
    }
}
