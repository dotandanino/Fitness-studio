package gym.management;

import gym.customers.Client;
import gym.customers.Instructor;
import gym.customers.Person;
import gym.management.Sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static Gym gym;
    private static String name;
    private Secretary secretary;
    private int balance;
    public void addBalance(int i){
        balance+=i;
    }
    private Gym(){
        balance=0;
    }
    public static Gym getInstance() {
        if(gym==null){
            gym=new Gym();
        }
        return gym;
    }

    public void setName(String crossFit) {
        name=crossFit;
    }

    public void setSecretary(Person p1, int i) {
        Secretary s1=new Secretary(p1,i);
        ArrayList<String> msg=new ArrayList<>();
        if(secretary!=null) {
            msg=this.secretary.getNotifications();
            this.secretary.setNotifications(null);
            secretary.setReg(null);
        }
        s1.setNotifications(msg);
        this.secretary=new Secretary(s1);
        secretary.addNotification("A new secretary has started working at the gym: "+p1.getName());
    }
    public Secretary getSecretary() {
        return secretary;
    }
    @Override
    public String toString(){
        String str="Gym Name: "+name+"\n";
        str+="Gym Secretary: "+secretary.toString()+"\n";
        str+="Gym Balance: "+balance+"\n\n";
        str+="Clients Data:\n";
        for (Client c: secretary.reg){
            str+=c.toString()+"\n";
        }
        str+="\n";
        str+="Employees Data:\n";
        for(Instructor i:secretary.instructors){
            str+=i.toString()+"\n";
        }
        str+=secretary.toString()+"\n";
        str+="\n";
        str+="Sessions Data:";
        for (Session s:secretary.sessions){
            str+="\n"+s.toString();
        }
        return str;
    }
}
