import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop implements Runnable {
    private final int VALUE = 12345;
    private final int DAYS = 30;
    private final LongAdder longAdder;

    public Shop(LongAdder longAdder) {
        this.longAdder = longAdder;
    }

    private void report(LongAdder longAdder) {
        Random random = new Random();
        long[] days = new long[DAYS];
        for (int i = 0; i < days.length; i++) {
            days[i] = random.nextInt(VALUE);
            longAdder.add(days[i]);
        }
    }

    @Override
    public void run() {
        report(longAdder);
    }
}