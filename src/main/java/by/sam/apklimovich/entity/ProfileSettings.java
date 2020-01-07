package by.sam.apklimovich.entity;

import by.sam.apklimovich.model.IllnessDto;

import javax.swing.*;
import java.util.ArrayList;


public class ProfileSettings {
    private long id;
    private ImageIcon profileImage;
    private ArrayList<IllnessDto> history;
    private String currentTreatment;

    ProfileSettings() {
    }

    ProfileSettings(long id, ImageIcon profileImage, ArrayList<IllnessDto> history, String currentTreatment) {
        this.id = id;
        this.profileImage = profileImage;
        this.history = history;
        this.currentTreatment = currentTreatment;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTreatment(String treatment) {
        this.currentTreatment = treatment;
    }

    public String getCurrentTreatment() {
        return currentTreatment;
    }

    public void addHistory(IllnessDto illnessDto) {
        history.add(illnessDto);
    }

    public ArrayList<IllnessDto> getHistory() {
        return history;
    }

    public ImageIcon getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ImageIcon image) {
        this.profileImage = image;
    }
}
