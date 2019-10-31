package by.sam.apklimovich.repositories;

import by.sam.apklimovich.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Person, Long> {

}
