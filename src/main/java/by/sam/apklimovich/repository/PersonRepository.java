package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
