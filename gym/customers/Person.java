package gym.customers;

import gym.management.Dates;

import java.time.LocalDate;

public class Person {
    private String name;
    private int[] balance=new int[1];//array for the copy constructor because
    // the client, instructor and secretary should have the same balance
    //we know we could build new class but only for one int we preferred
    private Gender gender;
    private String dateStr;
    private LocalDate date;
    private static int IDStart=1111;
    private int ID;
    private String notifications;
    public Person(String name, int balance, Gender gender, String date) {
        this.balance[0]=balance;
        this.name=name;
        this.gender=gender;
        dateStr=date;
        this.date = Dates.toLocal(date);
        ID=IDStart;
        IDStart++;
    }

    public Person(Person person) {
        this.balance=person.balance;
        this.name=person.name;
        this.gender=person.gender;
        this.dateStr= person.dateStr;
        this.date=person.date;
        this.ID= person.ID;
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
        return balance[0];
    }

    @Override
    public boolean equals(Object o){
        Person p=(Person) o;
        return (this.ID==p.ID);
    }

    //ID: 1112 | Name: Nofar | Gender: Female | Birthday: 03-07-1998 | Age: 26 | Balance: 890
    @Override
    public String toString(){
        return "ID: "+ID+" | Name: "+name+" | Gender: "+gender+" | Birthday: "+dateStr+" | Age: "+Dates.ageCalculator(this)+" | Balance: "+balance[0];
    }

    public void addToBalance(int i) {
        balance[0]+=i;
    }
}
