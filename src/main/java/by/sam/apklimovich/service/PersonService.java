package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.model.NewPersonDto;
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
    PersonRepository personRepository;

    public void createPerson(Person p) {
        Logger logger = LoggerFactory.getLogger(PersonService.class);
        logger.info("personService object created ");
        personRepository.findAll();
        personRepository.save(p);
        personRepository.flush();
    }

    public void createPerson(String name, String surname, int who) {
        Logger logger = LoggerFactory.getLogger(PersonService.class);
        logger.info("personService object created ");
        personRepository.findAll();
        personRepository.save(new Person(name, surname, who));
        personRepository.flush();
    }

    public String geussWho(int who) {
        if (who == 1) {
            return "Doctor";
        } else {
            return "Patient";
        }
    }

    public boolean addUser(NewPersonDto newPersonDto) {
        personRepository.findAll();
        if (personRepository.findByLogin(newPersonDto.getNewLogin()) == null && newPersonDto.getNewLogin() != null && newPersonDto.getNewPassword().length() > 3){
            personRepository.save(new Person(newPersonDto.getNewWho(), newPersonDto.getNewLogin(),
                    newPersonDto.getNewPassword(), newPersonDto.getName(), newPersonDto.getSurname()));
            personRepository.flush();
            return true;
        }
        else {
            personRepository.flush();
            return false;
        }
    }
}
