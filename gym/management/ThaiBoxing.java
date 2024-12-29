package gym.management;

import gym.management.Sessions.SessionType;

public class ThaiBoxing extends Session {
    private static final int MAXCLIENTS=20;
    private static final int price=100;
    ThaiBoxing(String date, ForumType ft, Instructor i){
        super(date,ft,i, SessionType.ThaiBoxing, MAXCLIENTS, price);
    }
}
