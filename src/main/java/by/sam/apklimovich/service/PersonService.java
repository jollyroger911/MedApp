package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository pr;

    public void createPerson() {
        Logger logger = LoggerFactory.getLogger(PersonService.class);
        logger.info("personService object created ");
        pr.findAll();
        pr.save(new Person("Name", "LastName", 0));
        pr.flush();
    }
}
