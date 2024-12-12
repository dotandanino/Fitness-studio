package gym.customers;

public class Client {
    private Person person;
    public Client(Person person){
        this.person=person;
    }
    public String getName() {
        return person.getName();
    }

    public String getNotifications() {
        return this.person.getNotifications();
    }
//    @Override
//    public boolean equals(Object o){
//        Client c=(Client) o;
//        return c.person.equals(this.person);
//    }
}
