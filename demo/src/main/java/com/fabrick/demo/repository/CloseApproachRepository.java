package com.fabrick.demo.repository;

import com.fabrick.demo.entity.CloseApproach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CloseApproachRepository extends JpaRepository<CloseApproach, Long> {

    List<CloseApproach> findByAsteroidIdAndCloseApproachDateGreaterThanEqualOrderByCloseApproachDateAsc(Integer asteroidId, Date fromDate);

    List<CloseApproach> findByAsteroidIdAndCloseApproachDateGreaterThanEqualAndOrbitingBodyNotOrderByCloseApproachDateAsc(Integer asteroidId, Date fromDate, String orbitingBody);

}