package gym.management;

import gym.customers.Person;

public class Gym {
    private static Gym gym;
    private static String name;
    private static Secretary secretary;
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
        Secretary s1=new Secretary(p1,i);
        s1.setNotifications(secretary.getNotifications());
        secretary=s1;
    }
    public Secretary getSecretary() {
        return secretary;
    }
}
