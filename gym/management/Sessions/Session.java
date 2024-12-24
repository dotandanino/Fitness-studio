package gym.management.Sessions;

import gym.customers.Client;
import gym.management.Instructor;

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
    private LocalDateTime strToDate(String str){
        LocalDateTime Date= LocalDateTime.of(Integer.parseInt(str.substring(6,10)),Integer.parseInt(str.substring(3,5)),
                Integer.parseInt(str.substring(0,2)),Integer.parseInt(str.substring(11,13)),Integer.parseInt(str.substring(14,16)));
        return Date;
    }
    protected Session(String date, ForumType ft, Instructor i, SessionType st, int capacity, int price){
        this.capacity = capacity;
        this.reg=new ArrayList<>();
        this.forumType=ft;
        this.i=i;
        this.strDate=date;
        this.date=strToDate(date);
        this.sessionType=st;
        this.price=price;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public ForumType getForumType() {
        return forumType;
    }

    public Instructor getI() {
        return i;
    }

    public List<Client> getClients() {
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
