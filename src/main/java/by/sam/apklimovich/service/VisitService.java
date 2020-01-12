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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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
                                getDocDescriptionByDocId(item.getDoctorId())))));
        return arrayList;
    }

    public ArrayList<PersonDto> getVisitsByDicId(long id){
        ArrayList<PersonDto> arrayList = new ArrayList<>();
        getAllByDoctorId(id).forEach((item)->arrayList.add(new PersonDto(personService.getPersonsNameById(item.getPatientId()), item.getVisitTime())));
        return arrayList;
    }
}
