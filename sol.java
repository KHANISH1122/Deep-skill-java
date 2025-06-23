interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an email notification");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an SMS notification");
    }
}

abstract class NotificationFactory {
    abstract Notification createNotification();
}

class EmailNotificationFactory extends NotificationFactory {
    Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {
    Notification createNotification() {
        return new SMSNotification();
    }
}

public class Sol{
    public static void main(String[] args) {
        NotificationFactory factory1 = new EmailNotificationFactory();
        Notification email = factory1.createNotification();
        email.notifyUser();

        NotificationFactory factory2 = new SMSNotificationFactory();
        Notification sms = factory2.createNotification();
        sms.notifyUser();
    }
}
