package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PRepository extends JpaRepository<Person, Long> {

}
