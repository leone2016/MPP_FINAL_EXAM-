import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Notification {

    public static void sendAlert(String staff) {
        System.out.println("Alert sent: " + staff + " - " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        List<String> staffNotify = List.of("Alice", "Bob", "Charlie", "David", "Eve","Amanda", "Carl");

        //a
//        ExecutorService executor = Executors.newCachedThreadPool();

        //b //
        ExecutorService executor = Executors.newFixedThreadPool(8);

        for (String staff : staffNotify) {
            executor.execute(() -> sendAlert(staff));
        }

        executor.shutdown();
    }
}
