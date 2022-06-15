import java.util.ArrayList;

public class RecursiveHeapSort {
    public static void sort(ArrayList<Integer> list) {
        ArrayList<Integer> heapList = new ArrayList<>(list);
        list.clear();

        buildHeap(heapList);
        int size = heapList.size();

        for (int i = heapList.size()-1; i >= 0; i--) {
            list.add(heapList.get(0));
            heapList.set(0, heapList.get(i));
            size--;
            heapify(heapList, 0, 0, size);
        }
    }

    public static void swap(ArrayList<Integer> list, Integer i, Integer j) {
        Integer x = list.get(i);
        list.set(i, list.get(j));
        list.set(j, x);
    }

    public static void heapify(ArrayList<Integer> list, Integer m, Integer n, int size) {
        Integer pIdx = (int)Math.pow(2, m) - 1 + n; // The index of the parent.
        Integer lcIdx = (int)Math.pow(2, m+1) - 1 + 2 * n; // The index of the left child.
        Integer rcIdx = (int)Math.pow(2, m+1) + 2 * n; // The index of the right child.

        if (lcIdx > size - 1) { // (m, n) is a leaf
            return;
        }

        Integer p = list.get(pIdx);
        Integer lc = list.get(lcIdx);

        if (rcIdx > size - 1) { // only has a left child
            if (lc < p) {
                swap(list, pIdx, lcIdx);
                heapify(list, m + 1, 2 * n, size);
            }
            return;
        }
        
        Integer rc = list.get(rcIdx);

        if (lc < rc && lc < p) {
            swap(list, pIdx, lcIdx);
            heapify(list, m+1, 2*n, size);
        }
        else if (rc <= lc && rc < p) {
            swap(list, pIdx, rcIdx);
            heapify(list, m+1, 2*n+1, size);
        }
    }

    public static void buildHeap(ArrayList<Integer> list) {
        for (int i = list.size()-1; i >= 0; i--) {
            Integer m = (int)(Math.floor(Math.log(i+1) / Math.log(2)));
            Integer n = i + 1 - (int)Math.pow(2, m);
            heapify(list, m, n, list.size());
        }
    }
}
