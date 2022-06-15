import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class RecursiveHeapSortTest {
    @Test
    public void testHeapify1() {
        ArrayList<Integer> list = new ArrayList<>(
            Arrays.asList(1, 8, 4, 6, 5, 6, 7, 8, 7, 6, 8, 7, 8, 9, 8)
        );
        RecursiveHeapSort.heapify(list, 1, 0, list.size());
        ArrayList<Integer> expected = new ArrayList<>(
            Arrays.asList(1, 5, 4, 6, 6, 6, 7, 8, 7, 8, 8, 7, 8, 9, 8)
        );
        assertEquals(expected, list);
    }

    @Test
    public void testHeapify2() {
        ArrayList<Integer> list2 = new ArrayList<>(
                Arrays.asList(3, 2, 4));
        RecursiveHeapSort.heapify(list2, 0, 0, list2.size());
        ArrayList<Integer> expected2 = new ArrayList<>(
                Arrays.asList(2, 3, 4));
        assertEquals(expected2, list2);
    }
}
