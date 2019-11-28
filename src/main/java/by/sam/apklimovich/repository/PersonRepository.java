package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
   // @Query(value = "SELECT Person pr FROM medicineapp.persons p WHERE p.login = username", nativeQuery = true)
    Person findByLogin(String username);

    List<Person> findByWho(int who);
}
