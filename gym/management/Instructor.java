package gym.management;

import gym.customers.Person;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;

public class Instructor {
    private Person person;
    private int salary;
    private ArrayList<SessionType> sessionTypes;
    //package private to make sure we will have the option to build new instructor from Secretary but not from the main
    Instructor(Person p, int i, ArrayList<SessionType> sessionTypes) {
        this.person=p;
        this.salary=i;
        this.sessionTypes=sessionTypes;
    }
    public void addToBalance(int i){
        person.addToBalance(i);
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
    @Override
    public String toString(){
        String str= person.toString()+" | Role: Instructor | Salary per Hour: "+salary+" | Certified Classes: "+sessionTypes.get(0);
        for(int i=1;i<sessionTypes.size();i++){
            str+=", "+sessionTypes.get(i);
        }
        return str;
    }
}
