import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop implements Runnable {
    private final int VALUE = 12345;
    private final int DAYS = 30;
    private final LongAdder stat;

    public Shop(LongAdder stat) {
        this.stat = stat;
    }

    private void report(LongAdder longAdder) {
        Random random = new Random();
        long[] days = new long[DAYS];
        for (int i = 0; i < days.length; i++) {
            days[i] = random.nextInt(VALUE);
        }
        longAdder.add(Arrays.stream(days).sum());
    }

    @Override
    public void run() {
        report(stat);
    }
}