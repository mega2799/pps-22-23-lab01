package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImplementation implements CircularList{

    private final List<Integer> circularList;
    private int currentIndex = 0;

    private final static boolean DEBUG = false;
    
    public CircularListImplementation(){
        this.circularList = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
        if(DEBUG) System.out.print(String.format("\ncurrent: %d, list %s", this.currentIndex,this.circularList.toString()));
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        if(this.circularList.size() == 0) return Optional.empty();
        if(currentIndex >= this.circularList.size()) this.reset();
        return Optional.of(this.circularList.get(currentIndex++));
    }

    @Override
    public Optional<Integer> previous() {
        if(this.circularList.size() == 0) return Optional.empty();
        if(currentIndex < 0) this.maxReset();
        return Optional.of(this.circularList.get(currentIndex--));
    }

    private void maxReset() {
        this.currentIndex = this.circularList.size() - 1;
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
    }

    @Override
    public String toString() {
        return "CircularListImplementation [circularList=" + circularList + ", currentIndex=" + currentIndex + "]";
    }
    
    
}
