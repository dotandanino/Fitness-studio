package gym.management.Sessions;

import gym.management.Instructor;
import gym.management.Session;

public class MachinePilates extends Session {
    private static final int MAXCLIENTS=10;
    private static final int price=80;
    MachinePilates(String date, ForumType ft, Instructor i) {
        super(date,ft,i,SessionType.MachinePilates, MAXCLIENTS, price);
    }

    public int getPrice() {
        return price;
    }
}
