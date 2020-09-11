package counter;

public class Counter {
    private int counter;

    public Counter() {
        this.counter = 0;
    }

    public void increment() { counter++; }
    public int getCounter() { return counter; }
}