import java.util.concurrent.*;

/**
 * Created by kotu on 8/22/16.
 */
public class CallableEx {
    public static void main(String[] args) {

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());
        Integer result = null;
        try {
            result = future.get();
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);

        ///

        ExecutorService executor2 = Executors.newFixedThreadPool(1);

        Future<Integer> future2 = executor2.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        try {
            future2.get(1, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}
