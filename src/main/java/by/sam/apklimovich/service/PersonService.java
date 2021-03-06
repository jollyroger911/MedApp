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

    public void createPerson(Person p) {
        Logger logger = LoggerFactory.getLogger(PersonService.class);
        logger.info("personService object created ");
        pr.findAll();
        pr.save(p);
        pr.flush();
    }

    public void createPerson(String name, String surname, int who) {
        Logger logger = LoggerFactory.getLogger(PersonService.class);
        logger.info("personService object created ");
        pr.findAll();
        pr.save(new Person(name, surname, who));
        pr.flush();
    }

    public String geussWho(int who){
        if(who == 1){
            return "Doctor";
        }
        else{
            return "Patient";
        }
    }

}
