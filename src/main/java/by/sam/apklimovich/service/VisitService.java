package by.sam.apklimovich.service;

import by.sam.apklimovich.entity.Visit;
import by.sam.apklimovich.model.IllnessDto;
import by.sam.apklimovich.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;

@Service
@Transactional
public class VisitService {
    @Autowired
    public VisitRepository visitRepository;

    @Autowired
    private PersonService personService;

    public ArrayList<String> getFreeVisitTimeByDocId(long docId, Date date){
        ArrayList<String> visitTime = new ArrayList<>();
        visitRepository.findByDoctorIdAndDateAndStatus(docId, date, true).forEach((item)->visitTime.add(item.getVisitTime()));
        return visitTime;
    }

    public ArrayList<Date> getFreeVisitDateByDocIdAndDate(long docId, Date date){
        ArrayList<Date> visitDate = new ArrayList<>();
        visitRepository.findByDoctorIdAndDate(docId, date).forEach((item)->visitDate.add(item.getDate()));
        return visitDate;
    }

    public void setVisitDetails(String time, long doctorId, long patientId){
        visitRepository.findByDoctorIdAndVisitTime(doctorId, time).setPatientId(patientId);
        visitRepository.findByDoctorIdAndVisitTime(doctorId, time).setStatus(false);
    }

    public ArrayList<Visit> getAllByPatientId(long id){
        return visitRepository.findAllByPatientId(id);
    }

    public ArrayList<IllnessDto> getHistoryByPatId(long id){
        ArrayList<IllnessDto> arrayList = new ArrayList<>();
        getAllByPatientId(id).forEach((item)->arrayList.add(new IllnessDto(personService.getPersonsNameById(item.getDoctorId()), item.getDate(), item.getVisitTime(), "")));
        return arrayList;
    }

}
