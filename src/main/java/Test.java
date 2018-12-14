import java.util.concurrent.*;

public class Test {
    static ExecutorService e = Executors.newFixedThreadPool(10);
    static int N = 1000000;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            int length = (i == 0) ? 1 : i * 5;
            System.out.print(length + "\t");
            System.out.print(doTest(new LinkedBlockingQueue<>(length), N) + "\t");
            System.out.print(doTest(new ArrayBlockingQueue<>(length), N) + "\t");
            System.out.print(doTest(new SynchronousQueue<>(), N));
            System.out.println();
        }

        e.shutdown();
    }

    private static long doTest(final BlockingQueue<Integer> q, final int n) throws Exception {
        long t = System.nanoTime();

        e.submit(() -> {
            for (int i = 0; i < n; i++)
                try { q.put(i); } catch (InterruptedException ex) {}
        });

        Long r = e.submit(() -> {
            long sum = 0;
            for (int i = 0; i < n; i++)
                try { sum += q.take(); } catch (InterruptedException ex) {}
            return sum;
        }).get();
        t = System.nanoTime() - t;

        return (long)(1000000000.0 * N / t); // Throughput, items/sec
    }
}