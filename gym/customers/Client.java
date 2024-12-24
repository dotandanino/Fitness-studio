package gym.customers;

import gym.management.Member;
import gym.management.Sessions.ForumType;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Client implements Member {
    private Person person;
    private ArrayList<ForumType> forumTypes;
    private List<String> notifications;
    public Client(Person person){
        this.person=person;
        this.notifications=new ArrayList<>();
        this.forumTypes=new ArrayList<>();
        forumTypes.add(ForumType.All);
        if(person.getGender()==Gender.Male)
            forumTypes.add(ForumType.Male);
        else
            forumTypes.add(ForumType.Female);
        if(ageCalculator(person)>=65)
            forumTypes.add(ForumType.Seniors);
    }

    public ArrayList<ForumType> getForumTypes() {
        return forumTypes;
    }
    public int getBalance() {
        return person.getBalance();
    }
    private static int ageCalculator(Person p){
        LocalDate now = LocalDate.now();
        LocalDate birth=p.getDate();
        Period period= Period.between(birth,now);
        return(period.getYears());
    }

    public String getName() {
        return person.getName();
    }
    public String getNotifications() {
        return String.valueOf(this.notifications);
    }
    @Override
    public boolean equals(Object o){
        Client c=(Client) o;
        return c.person.equals(this.person);
    }
    @Override
    public String toString(){
        return person.toString();
    }

    @Override
    public void update(String newsletter) {
        this.notifications.add(newsletter);
    }

    public void addToBalance(int i) {
        person.addToBalance(i);
    }
}
