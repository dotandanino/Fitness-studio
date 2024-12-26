package gym.management.Sessions;

import gym.management.Instructor;
import gym.management.Session;

public class Ninja extends Session {
    private static final int MAXCLIENTS=5;
    private static final int price=150;
    Ninja(String date, ForumType ft, Instructor i){
        super(date,ft,i,SessionType.Ninja, MAXCLIENTS, price);
    }
}