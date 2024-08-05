public class Counter {
    static int id = 0;

    public static int getAndIncrease() {
        return ++id;
    }
}
