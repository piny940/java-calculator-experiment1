import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class QuickSortTest {
    @Test
    public void testPartSort1() {
        ArrayList<Integer> list1 = new ArrayList<>(
            Arrays.asList(3, 4, 1)
        );
        QuickSort.partSort(list1, 0, 3);
        ArrayList<Integer> expected1 = new ArrayList<>(
            Arrays.asList(1, 3, 4)
        );
        assertEquals(expected1, list1);
    }

    @Test
    public void testPartSort2() {
        ArrayList<Integer> list2 = new ArrayList<>(
                Arrays.asList(4, 4, 1, 3, 4));
        QuickSort.partSort(list2, 0, 5);
        ArrayList<Integer> expected2 = new ArrayList<>(
                Arrays.asList(1,3,4,4,4));
        assertEquals(expected2, list2);
    }
}
