package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.ArrayList;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    ArrayList<Visit>findByDoctorIdAndStatus (long doctorId, boolean status);
    Visit findByDoctorIdAndVisitTime(long doctorId, String visitTime);
    ArrayList<Visit> findAllByPatientIdAndStatus(long patientId, boolean status);
    ArrayList<Visit> findByDoctorIdAndDate(long doctorId, Date date);
    ArrayList<Visit> findAllByDoctorIdAndStatus(long doctorId, boolean status);
}
