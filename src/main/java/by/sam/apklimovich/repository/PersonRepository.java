package by.sam.apklimovich.repository;

import by.sam.apklimovich.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Foo, Long> {

}
