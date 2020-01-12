package by.sam.apklimovich.model;

import javax.validation.constraints.Size;
import java.sql.Date;


public class PersonDto {
    @Size(min = 1)
    private String name;

    public String authorizedValue;

    @Size(min = 3)
    private String login;

    @Size(min = 3)
    private String password;

    private int who;

    private String status;

    public Date visitDate;


    @Size(min = 1)
    private String surname;

    private long id;

    private String personCred;

    private long destId;

    private long secondUserIs;

    private String visitData;

    private String newLogin;

    private String newPassword;

    private int newWho;

    public String content;

    private String visitTime;

    private long visitDoctorId;

    public Date currentDate;

    public String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public long getDestId() {
        return destId;
    }

    public void setDestId(long destId) {
        this.destId = destId;
    }

    public PersonDto() {
    }

    public String getPersonCred() {
        return personCred;
    }
    public String getAuthorizedValue() {
        return authorizedValue;
    }

    public void setAuthorizedValue(String authorizedValue) {
        this.authorizedValue = authorizedValue;
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

    public long getSecondUserIs() {
        return secondUserIs;
    }

    public void setSecondUserIs(long secondUserIs) {
        this.secondUserIs = secondUserIs;
    }

    public void setPersonCred(String personCred) {
        this.personCred = personCred;
    }

    public PersonDto(String name, String surname, long id, String description) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.description = description;
    }

    public PersonDto(String personCred, String visitTime, String description){
        this.personCred = personCred;
        this.visitTime = visitTime;
        this.description = description;
    }

    public PersonDto(String personCred, String visitTime){
        this.personCred = personCred;
        this.visitTime = visitTime;
    }

    PersonDto(String name, String surname, int id, String data) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.visitData = data;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public long getVisitDoctorId() {
        return visitDoctorId;
    }

    public void setVisitDoctorId(long visitDoctorId) {
        this.visitDoctorId = visitDoctorId;
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

    public long getId() {
        return id;
    }

    public void setId(long newId) {
        this.id = newId;
    }

    public String getVisitData() {
        return visitData;
    }

    public void setVisitData(String newVisitData) {
        this.visitData = newVisitData;
    }

    public String getNewLogin() {
        return newLogin;
    }

    public void setNewLogin(String newLogin) {
        this.newLogin = newLogin;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public int getNewWho() {
        return newWho;
    }

    public void setNewWho(int newWho) {
        this.newWho = newWho;
    }
}
