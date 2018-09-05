package mx.itesm.sensors;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService{
    //fqaTKlI1rb0:APA91bHQWsPZ3dGSI2kvS35zCAKsDk7TTp4gttXWSU2oY6bU9hBZcST80aWtQ9KPuu5GfyQkW3JOtlET-Vn049lhzC39Jz4h9IqprFOa7975podXKDZsoOFDbrzKq99ZJeAdOqYBZDbV
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();

        MyNotificationManager.getMyInstance(getApplicationContext()).DisplayNotification(title, body);
    }
}
