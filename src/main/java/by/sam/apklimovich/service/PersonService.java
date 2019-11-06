package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository pr;

    public void createPerson() {
        pr.findAll();
        pr.save(new Person("Name", "LastName"));
        pr.flush();
    }
}
