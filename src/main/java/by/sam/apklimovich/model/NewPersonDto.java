package by.sam.apklimovich.model;

public class NewPersonDto {
    private String newLogin;
    private String newPassword;
    private int newWho;

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
    public NewPersonDto (){}
}
