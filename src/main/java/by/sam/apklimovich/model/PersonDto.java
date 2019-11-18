package by.sam.apklimovich.model;

import javax.validation.constraints.Size;


public class PersonDto {


    @Size(min = 1)
    private String name;

    @Size(min = 3)
    private String login;

    @Size(min = 3)
    private String password;

    private int who;

    private String status;

    @Size(min = 1)
    private String surname;

    private int id;

    private String visitData;

    public String content;

    public PersonDto() {
    }

    PersonDto(String name, String surname, int id, String data) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.visitData = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWho() {
        return who;
    }

    public void setWho(int who) {
        this.who = who;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
}
