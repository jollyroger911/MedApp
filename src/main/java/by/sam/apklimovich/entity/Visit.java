package by.sam.apklimovich.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "VISITS")
public class Visit {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "doctor_Id")
    private long doctorId;

    @Column(name = "patient_Id")
    private long patientId;

    @Column(name = "time")
    private String visitTime;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Column(name = "status")
    private boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }



    public Visit(){}

    public Visit(long doctorId, long patientId, String visitTime){
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.visitTime = visitTime;
    }

    public Visit(long doctorId, String visitTime, boolean status){
        this.doctorId = doctorId;
        this.visitTime = visitTime;
        this.status = status;
    }


}
