package by.sam.apklimovich.model;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class IllnessDto {
    private String patientName;

    private String doctrosName;

    private Date visitDate;

    private String visitTime;

    private String doctorRecommendations;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctrosName() {
        return doctrosName;
    }

    public void setDoctrosName(String doctrosName) {
        this.doctrosName = doctrosName;
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

    public String getDoctorRecommendations() {
        return doctorRecommendations;
    }

    public void setDoctorRecommendations(String doctorRecommendations) {
        this.doctorRecommendations = doctorRecommendations;
    }
    public IllnessDto(){}

    public IllnessDto(String doctorsName, String visitTime, String doctorRecommendations){
        this.doctrosName = doctorsName;
        this.visitTime = visitTime;
        this.doctorRecommendations = doctorRecommendations;
    }
}
