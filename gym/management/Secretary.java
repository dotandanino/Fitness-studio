package gym.management;

import gym.customers.*;
import gym.management.Sessions.ForumType;
import gym.management.Sessions.Session;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;

public class Secretary {
    private Person person;
    private int salary;
    public Secretary(Person person, int salary) {
        this.person=person;
        this.salary=salary;
    }

    public Client registerClient(Person p4) {
        return null;
    }

    public void unregisterClient(Client c2) {
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
