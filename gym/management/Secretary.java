package gym.management;

import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.Exception.InvalidAgeException;
import gym.customers.*;
import gym.management.Sessions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Secretary {
    private Person person;
    private int balance=0;
    protected List<Session> sessions=new ArrayList<>();
    protected List<Instructor> instructors=new ArrayList<>();
    private int salary;
    protected ArrayList<Client> reg;
    private ArrayList<String> notifications;
    public Secretary(Person person, int salary) {
        this.person=person;
        this.salary=salary;
        this.notifications=new ArrayList<>();
        this.reg=new ArrayList<>();
    }
    public void setReg(ArrayList<Client> reg){
        this.reg=reg;
    }
    public Secretary(Secretary secretary) {
        this.person=secretary.person;
        this.salary=secretary.salary;
        this.notifications=secretary.notifications;
        this.reg=secretary.reg;
    }

    private static int ageCalculator(Person p){
        LocalDate now = LocalDate.now();
        LocalDate birth=p.getDate();
        Period period= Period.between(birth,now);
        return(period.getYears());
    }
    public Client registerClient(Person p) throws DuplicateClientException, InvalidAgeException {
        int age=ageCalculator(p);
        if(age<18)
            throw new InvalidAgeException();
        Client c=new Client(p);
        if(this.reg.contains(c)) {
            throw new DuplicateClientException("Error: The client is already registered");
        }
        reg.add(c);
        notifications.add("Registered new client: "+c.getName());
        return c;
    }

    public ArrayList<String> getNotifications(){
        return notifications;
    }

    public void setNotifications(ArrayList<String> notifications) {
        this.notifications = notifications;
    }

    public void unregisterClient(Client c2) throws ClientNotRegisteredException {
        for (int i = 0; i < reg.size(); i++) {
            if(reg.get(i).equals(c2)){
                reg.remove(i);
                notifications.add("Unregistered client: "+c2.getName());
                return;
            }
        }
        throw new ClientNotRegisteredException("Error: Registration is required before attempting to unregister");
    }

    public Instructor hireInstructor(Person p, int i, ArrayList<SessionType> sessionTypes) {
        this.notifications.add("Hired new instructor: "+p.getName()+" with salary per hour: "+i);
        Instructor I=new Instructor(p,i,sessionTypes);
        instructors.add(I);
        return I;
    }
    public Session addSession(SessionType type, String date, ForumType ft, Instructor i) throws InstructorNotQualifiedException {
        if(i.getSessionTypes().contains(type)) {
            Session session= sessionFactory.createSession(type, date, ft, i);
            sessions.add(session);
            notifications.add("Created new session: "+type+" on "+session.getDate().toString()+" with instructor: "+i.getName());
            return session;
        }
        throw new InstructorNotQualifiedException();
    }
    public void registerClientToLesson(Client c,Session s) throws DuplicateClientException, ClientNotRegisteredException {
        boolean exception=false;
        boolean possible=true;
        int error=0;//to indicate which Exception we want to throw.
        LocalDateTime sessionDate=s.getDate();
        LocalDateTime now=LocalDateTime.now();
        if(sessionDate.isBefore(now)){
            possible=false;
            this.notifications.add("Failed registration: Session is not in the future");
        }
        if(!c.getForumTypes().contains(s.getForumType())) {
            possible = false;
            String str;
            if(s.getForumType()==ForumType.Male || s.getForumType()==ForumType.Female){
                str="Failed registration: Client's gender doesn't match the session's gender requirements";
            }
            else{
                str="Failed registration: Client doesn't meet the age requirements for this session (Seniors)";
            }
            this.notifications.add(str);
        }
        if(s.getClients().size()==s.getSize()){
            possible=false;
            this.notifications.add("Failed registration: No available spots for session");
        }
        if(c.getBalance()<s.getPrice()){
            possible=false;
            this.notifications.add("Failed registration: Client doesn't have enough balance");
        }
        if(s.getClients().contains(c)){
            exception=true;
            error=1;
        }
        if(!this.reg.contains(c)){
            exception=true;
            error=2-error;//if we already have the first error we want to error to stay 1.
        }
        if(possible && ! exception) {
            s.getClients().add(c);
            c.setBalance(c.getBalance()-s.getPrice());
            balance+=s.getPrice();
            notifications.add("Registered client: "+c.getName()+" to session:"+ s.getSessionType()+" on "+s.getDate().toString() +" for price: "+s.getPrice());
        }
        else{
            if(exception) {
                if (error == 1)
                    throw new DuplicateClientException("Error: The client is already registered for this lesson");
                else
                    throw new ClientNotRegisteredException("Error: The client is not registered with the gym and cannot enroll in lessons");
            }
        }
    }
    public void paySalaries(){
        
    }

    public void printActions() {
        for (String str: notifications) {
            System.out.println(str);
        }
    }

    public void notify(Session s, String str) {

    }
    public void notify(String date, String str) {

    }
    public void notify(String str) {

    }

    public void addNotification(String s) {
        notifications.add(s);
    }
    @Override
    public String toString(){
        return person.toString()+" | Role: Secretary | Salary per Month: "+salary;
    }
}
