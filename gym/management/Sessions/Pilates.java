package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Pilates extends Session {
    private static final int MAXCLIENTS=30;
    private static final int price=60;
    protected Pilates(String date, ForumType ft, Instructor i){
        super(date,ft,i,SessionType.Pilates, MAXCLIENTS, price);
    }
}
