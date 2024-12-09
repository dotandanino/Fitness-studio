package gym.customers;

public class Person {
    private String name;
    private int balance;
    private Gender gender;
    private String notifications;
    public Person(String name, int balance, Gender gender, String notifications) {
        this.balance=balance;
        this.name=name;
        this.gender=gender;
        this.notifications=notifications;
    }

    public String getName() {
        return this.name;
    }

    public String getNotifications() {
        return this.notifications;
    }
}
