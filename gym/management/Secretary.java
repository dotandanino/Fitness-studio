package gym.management;

import gym.Exception.DuplicateClientException;
import gym.customers.*;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;
import java.util.List;

public class Secretary {
    private Person person;
    private int salary;
    private ArrayList<Client> reg;
    private ArrayList<String> notifications;
    public Secretary(Person person, int salary) {
        this.person=person;
        this.salary=salary;
        this.notifications=new ArrayList<>();
        this.reg=new ArrayList<>();
    }

    public Client registerClient(Person p) throws DuplicateClientException {
        Client c=new Client(p);
        if(this.reg.contains(c)) {
            throw new DuplicateClientException();
        }

        return c;
    }

    public ArrayList<String> getNotifications(){
        return notifications;
    }

    public void setNotifications(ArrayList<String> notifications) {
        this.notifications = notifications;
    }

    public void unregisterClient(Client c2) {
        for (int i = 0; i < reg.size(); i++) {

        }
    }

    public Instructor hireInstructor(Person p, int i, ArrayList<Object> objects) {
        return null;
    }
    public Session addSession(SessionType type, String date, ForumType ft, Instructor i){
        return null;
    }
    public void registerClientToLesson(Client c,Session s){

    }
    public void paySalaries(){
        
    }

    public void printActions() {
    }

    public void notify(Session s, String str) {

    }
    public void notify(String s, String str) {

    }
    public void notify(String str) {

    }
}
