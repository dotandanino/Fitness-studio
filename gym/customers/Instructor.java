package gym.customers;

import gym.management.Sessions.SessionType;

import java.util.ArrayList;

public class Instructor {
    private Person person;
    private int salary;
    private ArrayList<SessionType> sessionTypes;
    public Instructor(Person p, int i, ArrayList<SessionType> sessionTypes) {
        this.person=p;
        this.salary=i;
        this.sessionTypes=sessionTypes;
    }
    public void addToBalance(int i){
        person.setBalance(person.getBalance()+i);
    }
    public int getSalary() {
        return salary;
    }

    public ArrayList<SessionType> getSessionTypes() {
        return sessionTypes;
    }

    public String getName() {
        return person.getName();
    }
}
