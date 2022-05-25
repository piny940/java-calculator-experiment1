import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class NonrecursiveHeapSortTest {
    @Test
    public void testHeapify1() {
        ArrayList<Integer> list = new ArrayList<>(
            Arrays.asList(1, 8, 4, 6, 5, 6, 7, 8, 7, 6, 8, 7, 8, 9, 8)
        );
        NonrecursiveHeapSort.heapify(list, 1);
        ArrayList<Integer> expected = new ArrayList<>(
            Arrays.asList(1, 5, 4, 6, 6, 6, 7, 8, 7, 8, 8, 7, 8, 9, 8)
        );
        assertEquals(expected, list);
    }

    @Test
    public void testHeapify2() {
        ArrayList<Integer> list2 = new ArrayList<>(
                Arrays.asList(3, 2, 4));
        NonrecursiveHeapSort.heapify(list2, 0);
        ArrayList<Integer> expected2 = new ArrayList<>(
                Arrays.asList(2, 3, 4));
        assertEquals(expected2, list2);
    }

    @Test
    public void testSort() {
        ArrayList<Integer> list3 = new ArrayList<>(
                Arrays.asList(4,1,3,4,32,2,3,4,2,6)
        );
        NonrecursiveHeapSort.sort(list3);
        ArrayList<Integer> expected3 = new ArrayList<>(
                Arrays.asList(1,2,2,3,3,4,4,4,6,32)
        );
        assertEquals(expected3, list3);
    }

    @Test
    public void getChildrenIdx() {
        int[] children = NonrecursiveHeapSort.getChildrenIdx(2);
        int[] expected4 = { 5, 6 };
        assertTrue(Arrays.equals(children, expected4));
    }
}
