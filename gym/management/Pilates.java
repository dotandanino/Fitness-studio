package gym.management;

import gym.management.Sessions.SessionType;

public class Pilates extends Session {
    private static final int MAXCLIENTS=30;
    private static final int price=60;
    protected Pilates(String date, ForumType ft, Instructor i){
        super(date,ft,i, SessionType.Pilates, MAXCLIENTS, price);
    }
}
