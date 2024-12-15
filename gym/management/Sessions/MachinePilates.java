package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.util.ArrayList;
import java.util.List;

public class MachinePilates extends Session {
    private static final int MAXCLIENTS=10;
    private static final int price=80;
    protected MachinePilates(String date, ForumType ft, Instructor i) {
        super(date,ft,i,SessionType.MachinePilates, MAXCLIENTS, price);
    }

    public int getPrice() {
        return price;
    }
}
