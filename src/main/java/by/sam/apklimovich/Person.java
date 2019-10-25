package by.sam.apklimovich;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int id;
    private String visitData;
    Person(String name, int id, String data){
        this.name = name;
        this.id = id;
        this.visitData = data;
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public int getId(){
        return id;
    }
    public void setId(int newId){
        this.id = newId;
    }
    public String getVisitData(){
        return visitData;
    }
    public void setVisitData(String newVisitData){
        this.visitData = newVisitData;
    }

    interface PersonDAO{
        public List<Person> getAllPersons();
        public void updatePerson(Person person);
        public void deletePerson(Person person);
    }

    class PersonDAOImplement implements PersonDAO{
        List<Person> Person;
        public PersonDAOImplement(){
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
