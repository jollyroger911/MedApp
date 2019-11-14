package by.sam.apklimovich.entity;

import by.sam.apklimovich.controllers.MainController;
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

    public void setWho(int who){
        this.who = who;
    }

    public int getWho(){
        return who;
    }

    public Person(String firstName, String lastName, int who){
        this.firstName = firstName;
        this.lastName = lastName;
        this.who = who;
        Logger logger = LoggerFactory.getLogger(Person.class);
        logger.info(firstName);
        logger.info(lastName);
        logger.info("person entity created");
    }
    public Person(){
        Logger logger = LoggerFactory.getLogger(Person.class);
        logger.info("person entity created");
    }

}