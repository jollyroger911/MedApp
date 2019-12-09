package by.sam.apklimovich.service;

import by.sam.apklimovich.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class VisitService {
    @Autowired
    public VisitRepository visitRepository;



    public ArrayList<String> getFreeVisitTimeByDocId(long docId){
        ArrayList<String> visitTime = new ArrayList<>();
        visitRepository.findByDoctorIdAndStatus(docId, true).forEach((item)->visitTime.add(item.getVisitTime()));
        return visitTime;
    }

}
