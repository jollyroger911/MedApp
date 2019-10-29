package by.sam.apklimovich;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Person {

    @Size(min = 1)
    private String name;

    private int id;

    private String visitData;

    public String content;

    Person() {
    }

    Person(String name, int id, String data) {
        this.name = name;
        this.id = id;
        this.visitData = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public String getVisitData() {
        return visitData;
    }

    public void setVisitData(String newVisitData) {
        this.visitData = newVisitData;
    }

    interface PersonDAO {
        public List<Person> getAllPersons();

        public void updatePerson(Person person);

        public void deletePerson(Person person);
    }


    class PersonDAOImplement implements PersonDAO {
        List<Person> Person;

        public PersonDAOImplement() {
            Person = new ArrayList<>();

        }

        @Override
        public List<by.sam.apklimovich.Person> getAllPersons() {
            return null;
        }

        @Override
        public void updatePerson(by.sam.apklimovich.Person person) {

        }

        @Override
        public void deletePerson(by.sam.apklimovich.Person person) {

        }
    }
}
