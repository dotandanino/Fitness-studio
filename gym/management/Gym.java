package gym.management;
import gym.management.Session;
import gym.customers.*;

import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static Gym gym;
    private static String name;
    private Secretary secretary;
    int balance=0;
    private int gymBalance = 0;
    protected ArrayList<Session> sessions = new ArrayList<>();
    protected ArrayList<Instructor> instructors = new ArrayList<>();
    protected ArrayList<Client> clients=new ArrayList<>();
    protected ArrayList<String>  notifications = new ArrayList<>();
    private Gym(){

    }
    void addToBalnce(int i){
        this.gymBalance+=i;
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
        if(this.secretary!=null)
            this.secretary.isCurrent=false;
        this.secretary=new Secretary(p1,i);
        this.secretary.isCurrent=true;
        this.notifications.add("A new secretary has started working at the gym: "+p1.getName());
    }
    public Secretary getSecretary() {
        return secretary;
    }
    @Override
    public String toString(){
        String str="Gym Name: "+name+"\n";
        str+="Gym Secretary: "+secretary.toString()+"\n";
        str+="Gym Balance: "+gymBalance+"\n\n";
        str+="Clients Data:\n";
        for (Client c: clients){
            str+=c.toString()+"\n";
        }
        str+="\n";
        str+="Employees Data:\n";
        for (Instructor i: instructors){
            str+=i.toString()+"\n";
        }
        str+=secretary.toString()+"\n";
        str+="\n";
        str+="Sessions Data:";
        for (Session s:sessions){
            str+="\n"+s.toString();
        }
        return str;
    }
}
