package gym.management;

import gym.management.Sessions.SessionType;

public class sessionFactory {
    protected static Session createSession(SessionType st, String date, ForumType ft, Instructor i){
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
