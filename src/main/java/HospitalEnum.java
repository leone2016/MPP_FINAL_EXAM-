enum NotificationService {
    INSTANCE;

    public void sendAlert(String message) {
        System.out.println("ALERT: " + message);
    }
}
public class HospitalEnum {
    public static void main(String[] args) {
        NotificationService.INSTANCE.sendAlert("Emergency in Ward 7!");

        //why is enum is better for singleton?
        /*
        becasuse enum is thread-safe means that it doen't need sync blocks
         */
    }
}
