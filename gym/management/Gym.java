package gym.management;

import gym.customers.Person;

public class Gym {
    private static Gym gym;
    private static String name;
    private Secretary secretary;
    int balance=0;
    private Gym(){

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
        this.secretary=new Secretary(p1,i);
        secretary.addNotification("A new secretary has started working at the gym: "+p1.getName());
    }
    public Secretary getSecretary() {
        return secretary;
    }
    @Override
    public String toString(){
        String str="Gym Name: "+name+"\n";
        str+="Gym Secretary: "+secretary.toString()+"\n";
        str+="Gym Balance: "+secretary.getGymBalance()+"\n\n";
        str+="Clients Data:\n";
        str+=secretary.clientsPrint();
        str+="\n";
        str+="Employees Data:\n";
        str+=secretary.instructursPrint();
        str+=secretary.toString()+"\n";
        str+="\n";
        str+="Sessions Data:";
        str+=secretary.sessionPrint();
        return str;
    }
}
