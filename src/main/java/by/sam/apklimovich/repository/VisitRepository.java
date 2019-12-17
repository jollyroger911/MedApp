package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.ArrayList;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    ArrayList<Visit>findByDoctorIdAndDateAndStatus (long doctorId, Date date, boolean status);
    Visit findByDoctorIdAndVisitTime(long doctorId, String visitTime);
    ArrayList<Visit> findAllByPatientId(long patientId);
    ArrayList<Visit> findByDoctorIdAndDate(long doctorId, Date date);
}
