import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMerge1() {
        ArrayList<Integer> list1 = new ArrayList<>(
            Arrays.asList(4,2)
        );
        MergeSort.merge(list1, 0, 2);
        ArrayList<Integer> expected1 = new ArrayList<>(
            Arrays.asList(2, 4)
        );
        assertEquals(expected1, list1);
    }

    @Test
    public void testMerge2() {
        ArrayList<Integer> list2 = new ArrayList<>(
                Arrays.asList(32,4,23));
        MergeSort.merge(list2, 0, 3);
        ArrayList<Integer> expected2 = new ArrayList<>(
                Arrays.asList(4,23,32));
        assertEquals(expected2, list2);
    }
}
