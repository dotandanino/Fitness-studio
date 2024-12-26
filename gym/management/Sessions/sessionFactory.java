package gym.management.Sessions;

import gym.management.Instructor;
import gym.management.Session;

public class sessionFactory {
    public static Session createSession(SessionType st, String date, ForumType ft, Instructor i){
        switch (st){
            case Pilates:
                return new Pilates(date, ft, i);
            case ThaiBoxing:
                return new ThaiBoxing(date, ft, i);
            case MachinePilates:
                return new MachinePilates(date, ft, i);
            case Ninja:
                return new Ninja(date, ft, i);
            default:
                return null;
        }
    }
}
