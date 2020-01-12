package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.model.NewPersonDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    static int DOCTOR = 1;
    static int PATIENT = 0;

    public PersonDto getUserInfoByUsername(PersonDto personDto, String name){
        Person p = personRepository.findByLogin(name);
        personDto.setId(p.getId());
        personDto.setWho(p.getWho());
        personDto.setName(p.getFirstName());
        personDto.setSurname(p.getLastName());
        return personDto;
    }

    public String getDestinationUsername(long destId){
        return personRepository.findById(destId).get().getLogin();
    }

    public void createPerson(Person p) {
        Logger logger = LoggerFactory.getLogger(PersonService.class);
        logger.info("personService object created ");
        personRepository.findAll();
        personRepository.save(p);
        personRepository.flush();
    }

    public String getPersonsNameById(long id){
        Person p = personRepository.findById(id).get();
        StringBuilder stringBuilder = new StringBuilder(p.getFirstName());
        stringBuilder.append(" ");
        stringBuilder.append(p.getLastName());
        return String.valueOf(stringBuilder);
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
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            personRepository.save(new Person(newPersonDto.getNewWho(), newPersonDto.getNewLogin(),
                    passwordEncoder.encode(newPersonDto.getNewPassword()), newPersonDto.getName(), newPersonDto.getSurname()));
            personRepository.flush();
            return true;
        }
        else {
            personRepository.flush();
            return false;
        }
    }

    public String getPersonsDataForChat(long id){
        Person p = personRepository.findById(id).get();
        String result = p.getFirstName() + " " + p.getLastName();
        if (p.getWho() == DOCTOR){
            result += " (DOCTOR)";
        }
        else if(p.getWho() == PATIENT){
            result += " (PATIENT)";
        }
        else {
            result += " (ADMIN)";
        }
        return result;
    }

    public List<PersonDto> getDoctors(int who){
        List<Person> list = findAllPersonsByWho(who);
        List<PersonDto> listPersons = new ArrayList<PersonDto>();
        for(int i = 0; i < list.size(); i++){
            Locale locale;
            LocaleContext lc = LocaleContextHolder.getLocaleContext();
            locale = lc.getLocale();
//            String loc = locale.getLanguage();
//            loc = loc +"_"+loc.toUpperCase();
            ResourceBundle bundle = ResourceBundle.getBundle("i18n/messages", Locale.forLanguageTag(locale.getLanguage()));
            String message = bundle.getString(list.get(i).getDescription());
            listPersons.add(new PersonDto(list.get(i).getFirstName(), list.get(i).getLastName(), list.get(i).getId(), message));
        }
        return listPersons;
    }

    public List<Person> findAllPersonsByWho(int who){
        return personRepository.findByWho(who);
    }
    public List<Person> findAllPersons(){
        return personRepository.findAll();
    }

    public String getDocDescriptionByDocId(long id){
        Person p = personRepository.findById(id).get();
        return p.getDescription();
    }
}
