package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.model.PersonDto;
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
            pa.setFirstName("admin");
            pa.setLastName("admin");
            p1.setFirstName("Anton");
            p1.setLastName("Klimovich");
            p2.setFirstName("Dima");
            p2.setLastName("Chubrik");
            personRepository.findAll();
            personRepository.save(pa);
            personRepository.save(p1);
            personRepository.save(p2);
            personRepository.flush();
        }
    }

    public Person findByLogin(String username) {
        return personRepository.findByLogin(username);
    }

    public boolean checkCredentials(String username, String password, PersonDto pDto) {
        Person pList = findByLogin(username);
        if (pList.getPassword().equals(password)) {
            pDto.setWho(pList.getWho());
            pDto.setId(pList.getId());
            pDto.setName(pList.getFirstName());
            pDto.setSurname(pList.getLastName());
            pDto.setLogin(pList.getLogin());
            return true;
        } else {
            return false;
        }
    }

    public void addUser(int who, String username, String password, String name, String surname) {
        personRepository.findAll();
        personRepository.save(new Person(who, username, password, name, surname));
        personRepository.flush();
    }

    public void deleteUser(long id) {
        personRepository.findById(id);
        personRepository.deleteById(id);
        personRepository.flush();
    }


}
