package gym.customers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Person {
    private String name;
    private int balance;
    private Gender gender;
    private String date;
    private String notifications;
    public Person(String name, int balance, Gender gender, String date) {
        this.balance=balance;
        this.name=name;
        this.gender=gender;
        this.date =date;

    }

    public String getName() {
        return this.name;
    }
    public String getNotifications() {
        return this.notifications;
    }
//    @Override
//    public boolean equals(Object o){
//        Person p=(Person) o;
//        return (this.name.equals(p.name));
//    }
}
