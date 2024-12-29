package gym.management;

public class NewsletterPublisher extends Sender{
    protected void sendNewsletter(String newsletter) {
        notifyMembers(newsletter);
    }
}
