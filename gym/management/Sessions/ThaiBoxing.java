package gym.management.Sessions;

import gym.customers.Instructor;

public class ThaiBoxing extends Session{
    private static final int MAXCLIENTS=20;
    private static final int price=100;
    protected ThaiBoxing(String date, ForumType ft, Instructor i){
        super(date,ft,i,SessionType.ThaiBoxing, MAXCLIENTS, price);
    }
}
