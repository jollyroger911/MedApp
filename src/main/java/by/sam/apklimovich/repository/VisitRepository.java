package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    ArrayList<Visit>findByDoctorIdAndStatus (long doctorId, boolean status);
    Visit findByDoctorIdAndAndVisitTime(long doctorId, String visitTime);
    ArrayList<Visit> findAllByPatientId(long patientId);
}
