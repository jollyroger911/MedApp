package by.sam.apklimovich;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Persons1 {


    @Size(min = 1)
    private String name;

    private int id;

    private String visitData;

    public String content;

    Persons1() {
    }

    Persons1(String name, int id, String data) {
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
        public List<Persons1> getAllPersons();

        public void updatePerson(Persons1 person);

        public void deletePerson(Persons1 person);
    }

    class PersonDAOImplement implements PersonDAO {
        List<Persons1> Person;

        public PersonDAOImplement() {
            Person = new ArrayList<>();

        }

        @Override
        public List<Persons1> getAllPersons() {
            return null;
        }

        @Override
        public void updatePerson(Persons1 person) {

        }

        @Override
        public void deletePerson(Persons1 person) {

        }
    }
}
