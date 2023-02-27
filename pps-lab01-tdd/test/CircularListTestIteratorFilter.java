import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import lab01.simpleIterator.CircularListItarableFilter;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTestIteratorFilter {
    private CircularListItarableFilter cl;

    @BeforeEach
    void before(){
        this.cl = new CircularListItarableFilter();
    }

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

    @Test
    public void addTest() {
        this.cl.add(23);
        assertEquals(this.cl.size(), 1);
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
    public void forwardIterator(){
        this.cl.add(90);
        this.cl.add(91);
        Iterator<Integer> simpleIterator = Arrays.asList(90, 91).iterator();
        Iterator<Integer> circolarIterator = this.cl.forwardIterator();
     //   Iterator<Integer> simpleIterator2 = Arrays.asList(90, 91).iterator();
        assertEquals(simpleIterator.next(), circolarIterator.next());
        assertEquals(simpleIterator.next(), circolarIterator.next());
        assertEquals(90, circolarIterator.next());
        assertEquals(91, circolarIterator.next());
    }
    

    @Test 
    public void backwardIterator(){
        this.cl.add(90);
        this.cl.add(91);
        this.cl.add(1);
        this.cl.add(92);
        Iterator<Optional<Integer>> circolarIterator = this.cl.backwardIterator();
        assertEquals(90, circolarIterator.next().get());
        assertEquals(92, circolarIterator.next().get());
        assertEquals(Optional.empty(), circolarIterator.next());
        assertEquals(91, circolarIterator.next().get());
        assertEquals(90, circolarIterator.next().get());
    }
}
