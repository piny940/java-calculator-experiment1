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
        int formerIdx = 0;
        int latterIdx = size/2;
        int current = startIdx;
        String[] tmpArr = new String[size];
        for (int i = 0; i < size; i++) {
            tmpArr[i] = list.get(startIdx + i);
        }
        while (formerIdx < size/2 && latterIdx < size) {
            if (tmpArr[formerIdx].compareTo(tmpArr[latterIdx]) > 0) {
                list.set(current, tmpArr[latterIdx]);
                latterIdx++;
            }
            else {
                list.set(current, tmpArr[formerIdx]);
                formerIdx++;
            }
            current++;
        }
        int remaining = size/2 - formerIdx;
        for (int i = 0; i < remaining; i++) {
            list.set(current + i, tmpArr[formerIdx + i]);
        }

    }
}
