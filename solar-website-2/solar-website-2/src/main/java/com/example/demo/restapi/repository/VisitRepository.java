package com.example.demo.restapi.repository;

import com.example.demo.restapi.entity.Visit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VisitRepository  extends JpaRepository<Visit, Long>{

}
