package by.sam.apklimovich.entity;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "who")
    private int who;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWho(int who) {
        this.who = who;
    }

    public int getWho() {
        return who;
    }

    public Person(String firstName, String lastName, int who) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.who = who;
        Logger logger = LoggerFactory.getLogger(Person.class);
        logger.info(firstName);
        logger.info(lastName);
        logger.info("person entity created");
    }

    public Person() {
        Logger logger = LoggerFactory.getLogger(Person.class);
        logger.info("person entity created");
    }
    public Person(int who, String username, String password){
        this.login = username;
        this.password = password;
        this.who = who;
    }

    public Person (int who, String username, String password, String name, String surname){
        this.login = username;
        this.who = who;
        this.password = password;
        this.firstName = name;
        this.lastName = surname;
    }

}