import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab01.abstractCircularList.CircularListImpl;
import lab01.simpleIterator.CircularListItarableSimple;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTestIterator {
    private CircularListImpl cl;

    @BeforeEach
    void before() {
        this.cl = new CircularListItarableSimple();
    }

    @Test
    public void addTest() {
        this.cl.add(23);
        assertEquals(this.cl.size(), 1);
    }

    @Test
    public void addTestWithNext() {
        this.cl.add(23);
        assertEquals(this.cl.forwardIterator().next(), 23);
    }

    @Test
    public void sizeTest() {
        IntStream.range(0, 200)
                .forEach((element) -> this.cl.add(element));
        assertEquals(this.cl.size(), 200);
    }

    @Test
    public void isEmptyTest() {
        assertEquals(this.cl.size(), 0);
    }

    @Test
    public void forwardIterator() {
        this.cl.add(90);
        this.cl.add(91);
        Iterator<Integer> simpleIterator = Arrays.asList(90, 91).iterator();
        Iterator<Integer> circolarIterator = this.cl.forwardIterator();
        // Iterator<Integer> simpleIterator2 = Arrays.asList(90, 91).iterator();
        assertEquals(simpleIterator.next(), circolarIterator.next());
        assertEquals(simpleIterator.next(), circolarIterator.next());
        assertEquals(90, circolarIterator.next());
        assertEquals(91, circolarIterator.next());
    }

    @Test
    public void backwardIterator() {
        this.cl.add(90);
        this.cl.add(91);
        this.cl.add(92);
        Iterator<Integer> circolarIterator = this.cl.backwardIterator();
        assertEquals(90, circolarIterator.next());
        assertEquals(92, circolarIterator.next());
        assertEquals(91, circolarIterator.next());
        assertEquals(90, circolarIterator.next());
    }

}
