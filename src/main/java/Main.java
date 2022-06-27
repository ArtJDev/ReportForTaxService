import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final LongAdder report = new LongAdder();

        Thread shop1 = new Thread(new Shop(report));
        Thread shop2 = new Thread(new Shop(report));
        Thread shop3 = new Thread(new Shop(report));
        shop1.start();
        shop2.start();
        shop3.start();
        shop1.join();
        shop2.join();
        shop3.join();

        System.out.println(report);
    }
}