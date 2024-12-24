package gym.management;

public class NewsletterPublisher extends Sender{
    public void sendNewsletter(String newsletter) {
        notifyMembers(newsletter);
    }
}
