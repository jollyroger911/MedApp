package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    PersonRepository personRepository;

    public void isFirstStart() {
        if (personRepository.findAll().size() == 0) {
            Person pa = new Person(2, "admin", "admin");
            Person p1 = new Person(0, "user", "user");
            Person p2 = new Person(1, "doctor", "doctor");
            personRepository.findAll();
            personRepository.save(pa);
            personRepository.save(p1);
            personRepository.save(p2);
            personRepository.flush();
        }
    }

    public void addUser(int who, String username, String password) {
        Person p = new Person(who, username, password);
        personRepository.findAll();
        personRepository.save(p);
        personRepository.flush();
    }

    public void deleteUser(long id) {
        personRepository.findById(id);
        personRepository.deleteById(id);
        personRepository.flush();
    }


}
