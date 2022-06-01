import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class MyEdgeTest {
    @Test
    public void testEquals1() {
        MyEdge edge1 = new MyEdge(3, 5, 2);
        MyEdge edge2 = new MyEdge(3, 5, 2);
        // When using "==", the result will be false even when instance variables are
        // all the same.
        assertFalse(edge1 == edge2);
    }

    @Test
    public void testEquals2() {
        MyEdge edge1 = new MyEdge(3, 5, 2);
        MyEdge edge2 = new MyEdge(3, 5, 1);
        assertFalse(edge1 == edge2);
    }

    @Test
    public void testEquals3() {
        MyEdge edge1 = new MyEdge(3, 5, 2);
        MyEdge edge2 = new MyEdge(3, 5, 1);
        MyEdge edge3 = new MyEdge(3, 5, 2);
        HashSet<MyEdge> set = new HashSet<>();
        set.add(edge1);
        set.add(edge2);
        set.add(edge3);
        HashSet<MyEdge> expected = new HashSet<>();
        expected.add(new MyEdge(3, 5, 2));
        expected.add(new MyEdge(3, 5, 1));
        assertEquals(expected, set);
    }

    @Test
    public void testEquals4() {
        MyEdge edge1 = new MyEdge(3, 5, 2);
        MyEdge edge2 = new MyEdge(3, 5, 2);
        assertTrue(edge1.equals(edge2));
    }
}
