package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.entity.Visit;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.repository.PersonRepository;
import by.sam.apklimovich.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    VisitRepository visitRepository;

    public void isFirstStart() {
        if (personRepository.findAll().size() == 0) {
            Person pa = new Person(2, "admin", "admin");
            Person p1 = new Person(0, "user", "user");
            Person p2 = new Person(1, "doctor", "doctor");
            Person p3 = new Person(1, "doctor1", "1");
            pa.setFirstName("admin");
            pa.setLastName("admin");
            p1.setFirstName("Anton");
            p1.setLastName("Klimovich");
            p2.setFirstName("Dima");
            p2.setLastName("Chubrik");
            p3.setLastName("dssdgsdgv");
            p3.setFirstName("xcdbxbd");
            personRepository.findAll();
            personRepository.save(pa);
            personRepository.save(p1);
            personRepository.save(p2);
            personRepository.save(p3);
            personRepository.flush();
            Visit v1_1 = new Visit(p2.getId(), "10.00-11.00", true);
            Visit v1_2 = new Visit(p2.getId(), "11.00-12.00", true);
            Visit v1_3 = new Visit(p2.getId(), "12.00-13.00", true);
            Visit v1_4 = new Visit(p2.getId(), "13.00-14.00", true);
            Visit v1_5 = new Visit(p2.getId(), "14.00-15.00", true);
            Visit v2_1 = new Visit(p3.getId(), "10.00-11.00", true);
            Visit v2_2 = new Visit(p3.getId(), "11.00-12.00", true);
            Visit v2_3 = new Visit(p3.getId(), "12.00-13.00", true);
            Visit v2_4 = new Visit(p3.getId(), "13.00-14.00", true);
            Visit v2_5 = new Visit(p3.getId(), "14.00-15.00", true);
            visitRepository.save(v1_1);
            visitRepository.save(v1_2);
            visitRepository.save(v1_3);
            visitRepository.save(v1_4);
            visitRepository.save(v1_5);
            visitRepository.save(v2_1);
            visitRepository.save(v2_2);
            visitRepository.save(v2_3);
            visitRepository.save(v2_4);
            visitRepository.save(v2_5);
            visitRepository.flush();
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
