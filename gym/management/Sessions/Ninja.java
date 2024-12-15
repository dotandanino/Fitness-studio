package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Ninja extends Session {
    private static final int MAXCLIENTS=5;
    private static final int price=150;
    protected Ninja(String date, ForumType ft, Instructor i){
        super(date,ft,i,SessionType.Ninja, MAXCLIENTS, price);
    }
}
