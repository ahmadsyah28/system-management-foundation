public interface NotificationProvider {
    public void sendNotification(String recipient, String message);
    public void sendReport(String recipient, String report);
}