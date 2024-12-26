package gym.management;

import gym.Exception.ClientNotRegisteredException;
import gym.Exception.DuplicateClientException;
import gym.Exception.InstructorNotQualifiedException;
import gym.Exception.InvalidAgeException;
import gym.customers.*;
import gym.management.Sessions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Secretary extends Person{
    private int salary;
    boolean isCurrent;
    /**
     * the next are static because i want to keep this data in case we switch secretary;
     */
    public Secretary(Person person, int salary) {
        super(person);
        this.salary = salary;;
    }

    /**
     * check if this secretary equals to current gym secretary.
     * @return if this is the current secretary of from the past
     */
    public Client registerClient(Person p) {
        if(!this.isCurrent)
            throw new NullPointerException();
        int age = Dates.ageCalculator(p);
        Gym gym=Gym.getInstance();
        if (age < 18)
            throw new InvalidAgeException("Error: Client must be at least 18 years old to register");
        Client c = new Client(p);
        if (gym.clients.contains(c)) {
            throw new DuplicateClientException("Error: The client is already registered");
        }
        gym.clients.add(c);
        gym.notifications.add("Registered new client: " + c.getName());
        return c;
    }

    public void unregisterClient(Client c2) {
        if(!this.isCurrent)
            throw new NullPointerException();
        Gym gym=Gym.getInstance();
        ArrayList<Client> clients=gym.clients;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).equals(c2)) {
                clients.remove(i);
                gym.notifications.add("Unregistered client: " + c2.getName());
                return;
            }
        }
        throw new ClientNotRegisteredException("Error: Registration is required before attempting to unregister");
    }

    public Instructor hireInstructor(Person p, int i, ArrayList<SessionType> sessionTypes) {
        if(!this.isCurrent)
            throw new NullPointerException();
        Gym gym=Gym.getInstance();
        gym.notifications.add("Hired new instructor: " + p.getName() + " with salary per hour: " + i);
        Instructor I = new Instructor(p, i, sessionTypes);
        gym.instructors.add(I);
        return I;
    }

    public Session addSession(SessionType type, String date, ForumType ft, Instructor i) {
        if(!this.isCurrent)
            throw new NullPointerException();
        Gym gym=Gym.getInstance();
        if (i.getSessionTypes().contains(type)) {
            Session session = sessionFactory.createSession(type, date, ft, i);
            gym.sessions.add(session);
            gym.notifications.add("Created new session: " + type + " on " + session.getDate().toString() + " with instructor: " + i.getName());
            return session;
        }
        throw new InstructorNotQualifiedException("Error: Instructor is not qualified to conduct this session type.");
    }

    public void registerClientToLesson(Client c, Session s){
        if(!this.isCurrent)
            throw new NullPointerException();
        Gym gym=Gym.getInstance();
        boolean possible = true;
        LocalDateTime sessionDate = s.getDate();
        LocalDateTime now = LocalDateTime.now();
        if (s.getClients().contains(c)) {
            throw new DuplicateClientException("Error: The client is already registered for this lesson");
        }
        if (!gym.clients.contains(c)) {
            throw new ClientNotRegisteredException("Error: The client is not registered with the gym and cannot enroll in lessons");
        }
        if (sessionDate.isBefore(now)) {
            possible = false;
            gym.notifications.add("Failed registration: Session is not in the future");
        }
        if (!c.getForumTypes().contains(s.getForumType())) {
            possible = false;
            String str;
            if (s.getForumType() == ForumType.Male || s.getForumType() == ForumType.Female) {
                str = "Failed registration: Client's gender doesn't match the session's gender requirements";
            } else {
                str = "Failed registration: Client doesn't meet the age requirements for this session (Seniors)";
            }
            gym.notifications.add(str);
        }
        if (s.getClients().size() == s.getCapacity()) {
            possible = false;
            gym.notifications.add("Failed registration: No available spots for session");
        }
        if (c.getBalance() < s.getPrice()) {
            possible = false;
            gym.notifications.add("Failed registration: Client doesn't have enough balance");
        }

        if (possible) {
            s.getClients().add(c);
            c.addToBalance(-s.getPrice());
            gym.addToBalnce(s.getPrice());
            gym.notifications.add("Registered client: " + c.getName() + " to session: " + s.getSessionType() + " on " + s.getDate().toString() + " for price: " + s.getPrice());
        }
    }

    public void paySalaries() {
        if(!this.isCurrent)
            throw new NullPointerException();
        int counter=0;
        Instructor instructor;
        int salary;
        Gym gym=Gym.getInstance();
        for (Session s:gym.sessions){
            instructor=s.getI();
            salary=instructor.getSalary();
            instructor.addToBalance(salary);
            counter+=salary;
        }
        counter+=this.salary;
        this.addToBalance(this.salary);
        gym.addToBalnce(-counter);
        gym.notifications.add("Salaries have been paid to all employees");
    }
    public void printActions() {
        if(!this.isCurrent)
            throw new NullPointerException();
        Gym gym=Gym.getInstance();
        for (String str : gym.notifications) {
            System.out.println(str);
        }
    }
    public void notify(Session s, String str) {
        if(!this.isCurrent)
            throw new NullPointerException();
        NewsletterPublisher newsletterPublisher = new NewsletterPublisher();
        for (Client c : s.getClients()) {
            newsletterPublisher.register(c);
        }
        Gym gym=Gym.getInstance();
        newsletterPublisher.notifyMembers(str);
        gym.notifications.add("A message was sent to everyone registered for session "+s.getSessionType()+" on "+s.getDate()+" : "+str);
    }

    public void notify(String date, String str) {
        if(!this.isCurrent)
            throw new NullPointerException();
        NewsletterPublisher newsletterPublisher = new NewsletterPublisher();
        Gym gym=Gym.getInstance();
        for (Session s:gym.sessions){
            if((s.getStrDate().substring(0,10)).equals(date)){
                for (Client c : s.getClients()) {
                    newsletterPublisher.register(c);
                }
            }
        }
        newsletterPublisher.sendNewsletter(str);

        gym.notifications.add("A message was sent to everyone registered for a session on "+Dates.toLocal(date)+" : "+str);
    }
    public void notify(String str) {
        if(!this.isCurrent)
            throw new NullPointerException();
        Gym gym=Gym.getInstance();
        NewsletterPublisher newsletterPublisher = new NewsletterPublisher();
        for (Client c : gym.clients) {
            newsletterPublisher.register(c);
        }
        newsletterPublisher.notifyMembers(str);
        gym.notifications.add("A message was sent to all gym clients: " + str);
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Secretary | Salary per Month: " + salary;
    }
}
