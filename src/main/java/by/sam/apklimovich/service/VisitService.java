package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.entity.Visit;
import by.sam.apklimovich.model.IllnessDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
public class VisitService {
    @Autowired
    public VisitRepository visitRepository;

    @Autowired
    private PersonService personService;

    public ArrayList<String> getFreeVisitTimeByDocId(long docId){
        ArrayList<String> visitTime = new ArrayList<>();
        visitRepository.findByDoctorIdAndStatus(docId, true).forEach((item)->visitTime.add(item.getVisitTime()));
        return visitTime;
    }

//    public ArrayList<Date> getFreeVisitDateByDocIdAndDate(long docId, Date date){
//        ArrayList<Date> visitDate = new ArrayList<>();
//        visitRepository.findByDoctorIdAndDate(docId, date).forEach((item)->visitDate.add(item.getDate()));
//        return visitDate;
//    }

    public void setVisitDetails(String time, long doctorId, long patientId){
        visitRepository.findByDoctorIdAndVisitTime(doctorId, time).setPatientId(patientId);
        visitRepository.findByDoctorIdAndVisitTime(doctorId, time).setStatus(false);
    }

    public ArrayList<Visit> getAllByPatientId(long id){
        return visitRepository.findAllByPatientIdAndStatus(id, false);
    }

    public ArrayList<Visit> getAllByDoctorId(long id){
        return visitRepository.findAllByDoctorIdAndStatus(id, false);
    }

    public ArrayList<PersonDto> getHistoryByPatId(long id){
        Locale locale;
        LocaleContext lc = LocaleContextHolder.getLocaleContext();
        locale = lc.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("i18n/messages", Locale.forLanguageTag(locale.getLanguage()));
        ArrayList<PersonDto> arrayList = new ArrayList<>();
        getAllByPatientId(id).forEach((item)->arrayList.add(
                new PersonDto(personService.getPersonsNameById(item.getDoctorId()),
                        item.getVisitTime(),
                        bundle.getString(personService.
                                getDocDescriptionByDocId(item.getDoctorId())), item.getDoctorId())));
        return arrayList;
    }

    public void createNewDoctorsVisitTime(long id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now = LocalDate.now();
        Calendar cal = Calendar.getInstance();
        Visit v1_1 = new Visit(id, Date.valueOf(now),now.toString() + " 10.00-11.00", true);
        Visit v1_2 = new Visit(id, Date.valueOf(now),now.toString() + " 11.00-12.00", true);
        Visit v1_3 = new Visit(id, Date.valueOf(now),now.toString() + " 12.00-13.00", true);
        Visit v1_4 = new Visit(id, Date.valueOf(now),now.toString() + " 13.00-14.00", true);
        Visit v1_5 = new Visit(id, Date.valueOf(now),now.toString() + " 14.00-15.00", true);

        Visit v5_1 = new Visit(id, Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 10.00-11.00", true);
        Visit v5_2 = new Visit(id, Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 11.00-12.00", true);
        Visit v5_3 = new Visit(id, Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 12.00-13.00", true);
        Visit v5_4 = new Visit(id, Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 13.00-14.00", true);
        Visit v5_5 = new Visit(id, Date.valueOf(now.plusDays(1)),now.plusDays(1).toString() + " 14.00-15.00", true);

        Visit v9_1 = new Visit(id, Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 10.00-11.00", true);
        Visit v9_2 = new Visit(id, Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 11.00-12.00", true);
        Visit v9_3 = new Visit(id, Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 12.00-13.00", true);
        Visit v9_4 = new Visit(id, Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 13.00-14.00", true);
        Visit v9_5 = new Visit(id, Date.valueOf(now.plusDays(2)),now.plusDays(2).toString() + " 14.00-15.00", true);

        visitRepository.save(v1_1);
        visitRepository.save(v1_2);
        visitRepository.save(v1_3);
        visitRepository.save(v1_4);
        visitRepository.save(v1_5);

        visitRepository.save(v5_1);
        visitRepository.save(v5_2);
        visitRepository.save(v5_3);
        visitRepository.save(v5_4);
        visitRepository.save(v5_5);

        visitRepository.save(v9_1);
        visitRepository.save(v9_2);
        visitRepository.save(v9_3);
        visitRepository.save(v9_4);
        visitRepository.save(v9_5);

        visitRepository.flush();
    }

    public ArrayList<PersonDto> getVisitsByDocId(long id){
        ArrayList<PersonDto> arrayList = new ArrayList<>();
        getAllByDoctorId(id).forEach((item)->arrayList.add(new PersonDto(personService.getPersonsNameById(item.getPatientId()), item.getVisitTime())));
        return arrayList;
    }
}
