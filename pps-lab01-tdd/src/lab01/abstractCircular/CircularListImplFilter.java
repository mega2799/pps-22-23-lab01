package lab01.abstractCircular;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import lab01.tdd.CircularListImplementation;

public abstract class CircularListImplFilter{

    private final List<Integer> circularList;
    private int bruh = 0;

    private final static boolean DEBUG = false;
    
    public CircularListImplFilter(){
        this.circularList = new ArrayList<>();
    }

    public void add(int element) {
        this.circularList.add(element);
        if(DEBUG) System.out.print(String.format("\ncurrent: %d, list %s", this.bruh,this.circularList.toString()));
    }

    public int size() {
        return this.circularList.size();
    }

    public boolean isEmpty() {
        return this.circularList.size() == 0;
    }

   public Iterator<Integer> forwardIterator(){
        return new ForwardIterator<>(this.circularList);
  }

  public Iterator<Optional<Integer>> backwardIterator() {
      return new BackwardIterator<>(this.circularList, (element) -> ((Integer) element > 20));
  }

    private class BackwardIterator<Integer> implements Iterator{
        private final CircularListImplementation circularListImplementation = new CircularListImplementation();
        private final Predicate<Integer> filter;

        public BackwardIterator(List<Integer> listOfIntegers, Predicate<Integer> filter) {
            this.filter = filter;
            listOfIntegers.forEach((element) -> {
                this.circularListImplementation.add((int) element);
            });
            //System.out.println(this.circularListImplementation.toString());
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Optional<Integer> next() {
            Integer elementToTest = (Integer) this.circularListImplementation.previous().get();
            //System.out.println(filter.test(elementToTest));
            //System.out.println(elementToTest);
            if(filter.test(elementToTest)) return Optional.of(elementToTest);
            return Optional.empty();
        }

    }
    private class ForwardIterator<Integer> implements Iterator{
        private final CircularListImplementation circularListImplementation = new CircularListImplementation();

        public ForwardIterator(List<Integer> listOfIntegers) {
            listOfIntegers.forEach((element) -> {
                this.circularListImplementation.add((int) element);
            });
            //System.out.println(this.circularListImplementation.toString());
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return (Integer) this.circularListImplementation.next().get();
        }

    }

}
