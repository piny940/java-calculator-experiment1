import java.util.ArrayList;
import java.util.Arrays;

public class RecursiveHeapSortTest {
    public void testHeapify() {
        ArrayList<Integer> list1 = new ArrayList<>(
            Arrays.asList(1, 8, 4, 6, 5, 6, 7, 8, 7, 6, 8, 7, 8, 9, 8)
        );
        RecursiveHeapSort.heapify(list1, 1, 0);

    }
}
