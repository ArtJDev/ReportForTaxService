import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final LongAdder report = new LongAdder();

        for (int i = 0; i < 3; i++) {
            Thread stat = new Thread(new Shop(report));
            stat.start();
            stat.join();
        }

        System.out.println(report);
    }
}