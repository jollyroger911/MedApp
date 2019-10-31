package by.sam.apklimovich.repositories;

import by.sam.apklimovich.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
