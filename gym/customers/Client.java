package gym.customers;

import gym.management.Dates;
import gym.management.Member;
import gym.management.ForumType;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Member {
    private Person person;
    private ArrayList<ForumType> forumTypes;
    private List<String> notifications;
    public Client(Person person){
        super(person);
        this.notifications=new ArrayList<>();
        this.forumTypes=new ArrayList<>();
        forumTypes.add(ForumType.All);
        if(person.getGender()==Gender.Male)
            forumTypes.add(ForumType.Male);
        else
            forumTypes.add(ForumType.Female);
        if(Dates.ageCalculator(person)>=65)
            forumTypes.add(ForumType.Seniors);
    }

    public ArrayList<ForumType> getForumTypes() {
        return forumTypes;
    }

    public String getNotifications() {
        return String.valueOf(this.notifications);
    }
    @Override
    public void update(String newsletter) {
        this.notifications.add(newsletter);
    }
}
