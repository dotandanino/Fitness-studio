package gym.customers;

import gym.management.Sessions.ForumType;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

public class Person {
    private String name;
    private int balance;
    private Gender gender;
    private String dateStr;
    private LocalDate date;
    private static int IDStart=1111;
    private int ID;
    private String notifications;
    public Person(String name, int balance, Gender gender, String date) {
        this.balance=balance;
        this.name=name;
        this.gender=gender;
        dateStr=date;
        this.date = LocalDate.of(Integer.parseInt(date.substring(6,10)),Integer.parseInt(date.substring(3,5)),Integer.parseInt(date.substring(0,2)));
        ID=IDStart;
        IDStart++;
    }
    public Gender getGender(){
        return gender;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return this.name;
    }
    public String getNotifications() {
        return this.notifications;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o){
        Person p=(Person) o;
        return (this.ID==p.ID);
    }
    private static int ageCalculator(Person p){
        LocalDate now = LocalDate.now();
        LocalDate birth=p.getDate();
        Period period= Period.between(birth,now);
        return(period.getYears());
    }
    //ID: 1112 | Name: Nofar | Gender: Female | Birthday: 03-07-1998 | Age: 26 | Balance: 890
    @Override
    public String toString(){
        return "ID: "+ID+" | Name: "+name+" | Gender: "+gender+" | Birthday: "+dateStr+" | Age: "+ageCalculator(this)+" | Balance: "+balance;
    }
}
