package gym.customers;

import gym.management.Sessions.ForumType;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private Person person;
    private ArrayList<ForumType> forumTypes;
    private List<String> notifications;

    public ArrayList<ForumType> getForumTypes() {
        return forumTypes;
    }
    public int getBalance() {
        return person.getBalance();
    }

    public void setBalance(int balance) {
        person.setBalance(balance);
    }

    private static int ageCalculator(Person p){
        LocalDate now = LocalDate.now();
        LocalDate birth=p.getDate();
        Period period= Period.between(birth,now);
        return(period.getYears());
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

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
    public String getName() {
        return person.getName();
    }
    public void addNotification(String str){
        this.notifications.add(str);
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
}
