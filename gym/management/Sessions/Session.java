package gym.management.Sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Session {
    protected SessionType sessionType;
    protected ForumType forumType;
    protected Instructor i;
    protected List<Client> reg;
    protected LocalDateTime date;
    protected final int size;
    protected final int price;
    private LocalDateTime strToDate(String str){
        LocalDateTime Date= LocalDateTime.of(Integer.parseInt(str.substring(6,10)),Integer.parseInt(str.substring(3,5)),
                Integer.parseInt(str.substring(0,2)),Integer.parseInt(str.substring(11,13)),Integer.parseInt(str.substring(14,16)));
        return Date;
    }
    protected Session(String date, ForumType ft, Instructor i, SessionType st, int size,int price){
        this.size = size;
        this.reg=new ArrayList<>();
        this.forumType=ft;
        this.i=i;
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

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}
