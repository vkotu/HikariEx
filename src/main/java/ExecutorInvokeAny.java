import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by kotu on 8/22/16.
 */
public class ExecutorInvokeAny {
    static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();

        try {
            List<Callable<String>> callables = Arrays.asList(
                    callable("task1", 2),
                    callable("task2", 1),
                    callable("task3", 3));

            String result = executor.invokeAny(callables);
            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
