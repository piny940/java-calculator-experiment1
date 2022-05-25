import java.util.ArrayList;

public class NonrecursiveHeapSort {
    public static void sort(ArrayList<Integer> list) {
        ArrayList<Integer> heapList = new ArrayList<>(list);
        list.clear();

        buildHeap(heapList);

        for (int i = heapList.size()-1; i >= 0; i--) {
            list.add(heapList.get(0));
            heapList.set(0, heapList.get(i));
            heapList.remove(i);
            heapify(heapList, 0);
        }
    }

    public static void swap(ArrayList<Integer> list, Integer i, Integer j) {
        Integer x = list.get(i);
        list.set(i, list.get(j));
        list.set(j, x);
    }

    public static void heapify(ArrayList<Integer> list, Integer rootIdx) {
        Integer pIdx = rootIdx;

        while (getMinIdx(list, pIdx) != pIdx) {
            int minIdx = getMinIdx(list, pIdx);
            swap(list, pIdx, minIdx);
            pIdx = minIdx;
        }
    }

    public static int getMinIdx(ArrayList<Integer> list, Integer pIdx) {
        int[] childrenIdx = getChildrenIdx(pIdx);
        int lcIdx = childrenIdx[0]; // The index of the left child.
        int rcIdx = childrenIdx[1]; // The index of the right child.
        int minIdx = pIdx;

        if (lcIdx <= list.size()-1 && list.get(lcIdx) < list.get(minIdx)) {
            minIdx = lcIdx;
        }
        if (rcIdx <= list.size()-1 && list.get(rcIdx) < list.get(minIdx)) {
            minIdx = rcIdx;
        }
        return minIdx;
    }

    public static int[] getChildrenIdx(Integer pIdx) {
        int row = (int) (Math.floor(Math.log(pIdx + 1) / Math.log(2)));
        int col = pIdx + 1 - (int) Math.pow(2, row);
        int[] value = {
            (int)Math.pow(2, row+1) - 1 + 2 * col, // The index of the left child.
            (int)Math.pow(2, row+1) + 2 * col, // The index of the right child.
        };
        return value;
    }

    public static void buildHeap(ArrayList<Integer> list) {
        for (int i = list.size()-1; i >= 0; i--) {
            heapify(list, i);
        }
    }
}
