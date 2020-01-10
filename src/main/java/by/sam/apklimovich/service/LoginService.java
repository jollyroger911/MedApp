package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.entity.Visit;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.repository.PersonRepository;
import by.sam.apklimovich.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Service
@Transactional
public class LoginService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    VisitRepository visitRepository;

    public void isFirstStart() {
        if (personRepository.findAll().size() == 0) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Person pa = new Person(2, "admin", passwordEncoder.encode("admin"));
            Person p1 = new Person(0, "user", passwordEncoder.encode("user"));
            Person p2 = new Person(1, "doctor", passwordEncoder.encode("doctor"));
            Person p3 = new Person(1, "doctor1", passwordEncoder.encode("doctor1"));
            Person p4 = new Person(1, "doctor2", passwordEncoder.encode("doctor2"));
            Person p5 = new Person(1, "doctor3", passwordEncoder.encode("doctor3"));
            Person p6 = new Person(0, "user2", passwordEncoder.encode("user2"));
            Person p7 = new Person(0, "user1", passwordEncoder.encode("user1"));
            pa.setFirstName("admin");
            pa.setLastName("admin");
            p1.setFirstName("Anton");
            p1.setLastName("Klimovich");
            p2.setFirstName("Dima");
            p2.setLastName("Chubrik");
            p3.setFirstName("Vlados");
            p3.setLastName("Dekht");
            p4.setFirstName("Egor");
            p4.setLastName("Cheptsov");
            p5.setFirstName("Alex");
            p5.setLastName("Fridrikh");
            p6.setFirstName("Nikita");
            p6.setLastName("Fridrikh");
            p7.setFirstName("Gosha");
            p7.setLastName("Kobyakov");
            personRepository.findAll();
            personRepository.save(pa);
            personRepository.save(p1);
            personRepository.save(p2);
            personRepository.save(p3);
            personRepository.save(p4);
            personRepository.save(p5);
            personRepository.save(p6);
            personRepository.save(p7);
            personRepository.flush();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate now = LocalDate.now();
            Calendar cal = Calendar.getInstance();
            Visit v1_1 = new Visit(p2.getId(), Date.valueOf(now),now.toString() + " 10.00-11.00", true);
            Visit v1_2 = new Visit(p2.getId(), Date.valueOf(now),now.toString() + " 11.00-12.00", true);
            Visit v1_3 = new Visit(p2.getId(), Date.valueOf(now),now.toString() + " 12.00-13.00", true);
            Visit v1_4 = new Visit(p2.getId(), Date.valueOf(now),now.toString() + " 13.00-14.00", true);
            Visit v1_5 = new Visit(p2.getId(), Date.valueOf(now),now.toString() + " 14.00-15.00", true);
            Visit v2_1 = new Visit(p3.getId(), Date.valueOf(now),now.toString() + " 10.00-11.00", true);
            Visit v2_2 = new Visit(p3.getId(), Date.valueOf(now),now.toString() + " 11.00-12.00", true);
            Visit v2_3 = new Visit(p3.getId(), Date.valueOf(now),now.toString() + " 12.00-13.00", true);
            Visit v2_4 = new Visit(p3.getId(), Date.valueOf(now),now.toString() + " 13.00-14.00", true);
            Visit v2_5 = new Visit(p3.getId(), Date.valueOf(now),now.toString() + " 14.00-15.00", true);
            Visit v3_1 = new Visit(p4.getId(), Date.valueOf(now),now.toString() + " 10.00-11.00", true);
            Visit v3_2 = new Visit(p4.getId(), Date.valueOf(now),now.toString() + " 11.00-12.00", true);
            Visit v3_3 = new Visit(p4.getId(), Date.valueOf(now),now.toString() + " 12.00-13.00", true);
            Visit v3_4 = new Visit(p4.getId(), Date.valueOf(now),now.toString() + " 13.00-14.00", true);
            Visit v3_5 = new Visit(p4.getId(), Date.valueOf(now),now.toString() + " 14.00-15.00", true);
            Visit v4_1 = new Visit(p5.getId(), Date.valueOf(now),now.toString() + " 10.00-11.00", true);
            Visit v4_2 = new Visit(p5.getId(), Date.valueOf(now),now.toString() + " 11.00-12.00", true);
            Visit v4_3 = new Visit(p5.getId(), Date.valueOf(now),now.toString() + " 12.00-13.00", true);
            Visit v4_4 = new Visit(p5.getId(), Date.valueOf(now),now.toString() + " 13.00-14.00", true);
            Visit v4_5 = new Visit(p5.getId(), Date.valueOf(now),now.toString() + " 14.00-15.00", true);

            Visit v5_1 = new Visit(p2.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 10.00-11.00", true);
            Visit v5_2 = new Visit(p2.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 11.00-12.00", true);
            Visit v5_3 = new Visit(p2.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 12.00-13.00", true);
            Visit v5_4 = new Visit(p2.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 13.00-14.00", true);
            Visit v5_5 = new Visit(p2.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 14.00-15.00", true);
            Visit v6_1 = new Visit(p3.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 10.00-11.00", true);
            Visit v6_2 = new Visit(p3.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 11.00-12.00", true);
            Visit v6_3 = new Visit(p3.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 12.00-13.00", true);
            Visit v6_4 = new Visit(p3.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 13.00-14.00", true);
            Visit v6_5 = new Visit(p3.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 14.00-15.00", true);
            Visit v7_1 = new Visit(p4.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 10.00-11.00", true);
            Visit v7_2 = new Visit(p4.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 11.00-12.00", true);
            Visit v7_3 = new Visit(p4.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 12.00-13.00", true);
            Visit v7_4 = new Visit(p4.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 13.00-14.00", true);
            Visit v7_5 = new Visit(p4.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 14.00-15.00", true);
            Visit v8_1 = new Visit(p5.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 10.00-11.00", true);
            Visit v8_2 = new Visit(p5.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 11.00-12.00", true);
            Visit v8_3 = new Visit(p5.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 12.00-13.00", true);
            Visit v8_4 = new Visit(p5.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 13.00-14.00", true);
            Visit v8_5 = new Visit(p5.getId(), Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 14.00-15.00", true);

            Visit v9_1 = new Visit(p2.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 10.00-11.00", true);
            Visit v9_2 = new Visit(p2.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 11.00-12.00", true);
            Visit v9_3 = new Visit(p2.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 12.00-13.00", true);
            Visit v9_4 = new Visit(p2.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 13.00-14.00", true);
            Visit v9_5 = new Visit(p2.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 14.00-15.00", true);
            Visit v10_1 = new Visit(p3.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 10.00-11.00", true);
            Visit v10_2 = new Visit(p3.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 11.00-12.00", true);
            Visit v10_3 = new Visit(p3.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 12.00-13.00", true);
            Visit v10_4 = new Visit(p3.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 13.00-14.00", true);
            Visit v10_5 = new Visit(p3.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 14.00-15.00", true);
            Visit v11_1 = new Visit(p4.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 10.00-11.00", true);
            Visit v11_2 = new Visit(p4.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 11.00-12.00", true);
            Visit v11_3 = new Visit(p4.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 12.00-13.00", true);
            Visit v11_4 = new Visit(p4.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 13.00-14.00", true);
            Visit v11_5 = new Visit(p4.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 14.00-15.00", true);
            Visit v12_1 = new Visit(p5.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 10.00-11.00", true);
            Visit v12_2 = new Visit(p5.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 11.00-12.00", true);
            Visit v12_3 = new Visit(p5.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 12.00-13.00", true);
            Visit v12_4 = new Visit(p5.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 13.00-14.00", true);
            Visit v12_5 = new Visit(p5.getId(), Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 14.00-15.00", true);

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
            visitRepository.save(v3_1);
            visitRepository.save(v3_2);
            visitRepository.save(v3_3);
            visitRepository.save(v3_4);
            visitRepository.save(v3_5);
            visitRepository.save(v4_1);
            visitRepository.save(v4_2);
            visitRepository.save(v4_3);
            visitRepository.save(v4_4);
            visitRepository.save(v4_5);
            visitRepository.save(v5_1);
            visitRepository.save(v5_2);
            visitRepository.save(v5_3);
            visitRepository.save(v5_4);
            visitRepository.save(v5_5);
            visitRepository.save(v6_1);
            visitRepository.save(v6_2);
            visitRepository.save(v6_3);
            visitRepository.save(v6_4);
            visitRepository.save(v6_5);
            visitRepository.save(v7_1);
            visitRepository.save(v7_2);
            visitRepository.save(v7_3);
            visitRepository.save(v7_4);
            visitRepository.save(v7_5);
            visitRepository.save(v8_1);
            visitRepository.save(v8_2);
            visitRepository.save(v8_3);
            visitRepository.save(v8_4);
            visitRepository.save(v8_5);
            visitRepository.save(v9_1);
            visitRepository.save(v9_2);
            visitRepository.save(v9_3);
            visitRepository.save(v9_4);
            visitRepository.save(v9_5);
            visitRepository.save(v10_1);
            visitRepository.save(v10_2);
            visitRepository.save(v10_3);
            visitRepository.save(v10_4);
            visitRepository.save(v10_5);
            visitRepository.save(v11_1);
            visitRepository.save(v11_2);
            visitRepository.save(v11_3);
            visitRepository.save(v11_4);
            visitRepository.save(v11_5);
            visitRepository.save(v12_1);
            visitRepository.save(v12_2);
            visitRepository.save(v12_3);
            visitRepository.save(v12_4);
            visitRepository.save(v12_5);
            visitRepository.flush();
        }
    }

    public Person findByLogin(String username) {
        return personRepository.findByLogin(username);
    }

    public boolean  checkCredentials(String username, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Person pList = findByLogin(username);
        if (passwordEncoder.matches(password, pList.getPassword()) && pList != null) {
//            pDto.setWho(pList.getWho());
//            pDto.setId(pList.getId());
//            pDto.setName(pList.getFirstName());
//            pDto.setSurname(pList.getLastName());
//            pDto.setLogin(pList.getLogin());
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
