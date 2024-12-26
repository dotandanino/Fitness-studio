package gym.management.Sessions;

import gym.management.Instructor;
import gym.management.Session;

public class Pilates extends Session {
    private static final int MAXCLIENTS=30;
    private static final int price=60;
    Pilates(String date, ForumType ft, Instructor i){
        super(date,ft,i,SessionType.Pilates, MAXCLIENTS, price);
    }
}
