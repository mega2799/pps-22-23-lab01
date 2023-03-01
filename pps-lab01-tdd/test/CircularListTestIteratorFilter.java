import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab01.filteredIterator.CircularListItarableFilter;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTestIteratorFilter {
    private CircularListItarableFilter cl;

    @BeforeEach
    void before(){
        this.cl = new CircularListItarableFilter();
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
    public void filteredIterator(){
        this.cl.add(90);
        this.cl.add(91);
        this.cl.add(1);
        this.cl.add(92);
        Iterator<Optional<Integer>> circolarIterator = this.cl.filteredNext((element) -> ((Integer) element > 20));
        assertEquals(Optional.of(90), circolarIterator.next());
        assertEquals(Optional.of(91), circolarIterator.next());
        assertEquals(Optional.empty(), circolarIterator.next());
        assertEquals(Optional.of(92), circolarIterator.next());
        //again
        assertEquals(Optional.of(90), circolarIterator.next());
        assertEquals(Optional.of(91), circolarIterator.next());
        assertEquals(Optional.empty(), circolarIterator.next());
        assertEquals(Optional.of(92), circolarIterator.next());
    }
}
