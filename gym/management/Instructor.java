package gym.management;

import gym.customers.Person;
import gym.management.Sessions.SessionType;

import java.util.ArrayList;

public class Instructor extends Person{
    private int salary;
    private ArrayList<SessionType> sessionTypes;
    //package private to make sure we will have the option to build new instructor
    // from Secretary but not from the main
    protected Instructor(Person p, int i, ArrayList<SessionType> sessionTypes) {
        super(p);
        this.salary=i;
        this.sessionTypes=sessionTypes;
    }
    public int getSalary() {
        return salary;
    }

    public ArrayList<SessionType> getSessionTypes() {
        return sessionTypes;
    }
    @Override
    public String toString(){
        //using the person to string and add what we need for the instructor.
        String str= super.toString()+" | Role: Instructor | Salary per Hour: "+salary+" | Certified Classes: "+sessionTypes.get(0);
        for(int i=1;i<sessionTypes.size();i++){
            str+=", "+sessionTypes.get(i);
        }
        return str;
    }
}
