import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RandomTest {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    List<Callable<String>> tasks = new ArrayList<>();

    for (int i = 0; i < 50; i++) {
      tasks.add(() -> {
        runTest(Thread.currentThread().getName());
        return Thread.currentThread().getName() + " done!";
      });
    }

    executorService.invokeAll(tasks);
    executorService.shutdown();
    executorService.awaitTermination(100, TimeUnit.SECONDS);
  }

  public static void runTest(String threadName) {
    List<Integer> intList = new ArrayList<>();
    Random random = new Random();
    for(int i=0; i<30; i++) {
      int num = random.nextInt(30);
      intList.add(num);
//      System.out.print(num + " ");
    }

    int above = 0, below = 0;

    for (Integer integer : intList) {
      if (integer > 15)
        above++;
      else
        below++;
    }

    System.out.println(threadName + "| ABOVE: " + above + " | BELOW: " + below);
  }
}
