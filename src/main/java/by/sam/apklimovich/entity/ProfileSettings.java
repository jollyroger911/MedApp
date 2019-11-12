package by.sam.apklimovich.entity;

import by.sam.apklimovich.model.Illness;

import javax.swing.*;
import java.util.ArrayList;


public class ProfileSettings {
    private long id;
    private ImageIcon profileImage;
    private ArrayList <Illness> history;
    private String currentTreatment;
    ProfileSettings(){}
    ProfileSettings(long id ,ImageIcon profileImage, ArrayList<Illness> history, String currentTreatment){
        this.id = id;
        this.profileImage = profileImage;
        this.history = history;
        this.currentTreatment = currentTreatment;
    }
    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return  id;
    }
    public void setTreatment(String treatment){
        this.currentTreatment = treatment;
    }
    public String getCurrentTreatment(){
        return currentTreatment;
    }
    public void addHistory(Illness illness){
        history.add(illness);
    }
    public ArrayList<Illness> getHistory(){
        return history;
    }
    public ImageIcon getProfileImage(){
        return profileImage;
    }
    public void setProfileImage(ImageIcon image){
        this.profileImage = image;
    }
}
