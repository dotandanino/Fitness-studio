package gym.management;

import gym.customers.Client;
import gym.management.Sessions.SessionType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Session {
    protected SessionType sessionType;
    protected ForumType forumType;
    protected Instructor i;
    protected List<Client> reg;
    protected LocalDateTime date;
    protected String strDate;
    protected final int capacity;
    protected final int price;
    protected Session(String date, ForumType ft, Instructor i, SessionType st, int capacity, int price){
        this.capacity = capacity;
        this.reg=new ArrayList<>();
        this.forumType=ft;
        this.i=i;
        this.strDate=date;
        this.date= Dates.toLocalTime(date);
        this.sessionType=st;
        this.price=price;
    }
    public SessionType getSessionType() {
        return sessionType;
    }
    public ForumType getForumType() {
        return forumType;
    }
    protected Instructor getI() {return i;}
    List<Client> getClients() {
        return reg;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getPrice() {
        return price;
    }
    public String getStrDate(){
        return strDate;
    }
    @Override
    public String toString(){
        return "Session Type: "+sessionType+" | Date: "+strDate+" | Forum: "+forumType+" | Instructor: "+i.getName()+" | Participants: "+reg.size()+"/"+ capacity;
    }
}
