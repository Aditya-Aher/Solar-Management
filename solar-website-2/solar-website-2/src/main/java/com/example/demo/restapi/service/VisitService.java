package com.example.demo.restapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.restapi.entity.Visit;
import com.example.demo.restapi.repository.VisitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    public Optional<Visit> getVisitById(Long visitId) {
        return visitRepository.findById(visitId);
    }

    public Visit addVisit(Visit visit) {
        return visitRepository.save(visit);
    }


    public Visit updateVisitStatus(Long visitId, String status, String type) {
        Optional<Visit> visitOpt = visitRepository.findById(visitId);
        if (visitOpt.isPresent()) {
            Visit visit = visitOpt.get();
            if ("subcd".equalsIgnoreCase(type)) {
                visit.setSubcdStatus(status);
            } else if ("installation".equalsIgnoreCase(type)) {
                visit.setInstallationStatus(status);
            }
            return visitRepository.save(visit);
        }
        return null;
    }


    public void deleteVisit(Long visitId) {
        visitRepository.deleteById(visitId);
    }
}
