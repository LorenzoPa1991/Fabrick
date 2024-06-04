package com.fabrick.demo.service;

import com.fabrick.demo.dto.CloseApproachDto;
import com.fabrick.demo.entity.CloseApproach;
import com.fabrick.demo.repository.CloseApproachRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class AsteroidService {

    @Autowired
    private CloseApproachRepository closeApproachRepository;

    public List<CloseApproachDto> getCloseApproach(Integer asteroidId, Date fromDate, Date toDate) {
        try {
            List<CloseApproach> r1 = closeApproachRepository.findByAsteroidIdAndCloseApproachDateGreaterThanEqualOrderByCloseApproachDateAsc(asteroidId, fromDate);
            if (r1.isEmpty()) {
                throw new IllegalArgumentException("No close approaches found for the given asteroidId and fromDate.");
            }
            CloseApproach ca1 = r1.get(0);

            List<CloseApproach> r2 = closeApproachRepository.findByAsteroidIdAndCloseApproachDateGreaterThanEqualAndOrbitingBodyNotOrderByCloseApproachDateAsc(asteroidId, toDate, ca1.getOrbitingBody());
            if (r2.isEmpty()) {
                throw new IllegalArgumentException("No close approaches found for the given toDate and orbiting body.");
            }
            CloseApproach ca2 = r2.get(0);

            List<CloseApproach> r3 = closeApproachRepository.findByAsteroidIdAndCloseApproachDateGreaterThanEqualAndOrbitingBodyNotOrderByCloseApproachDateAsc(asteroidId, ca2.getCloseApproachDate(), ca2.getOrbitingBody());
            if (r3.isEmpty()) {
                throw new IllegalArgumentException("No subsequent close approaches found for the given conditions.");
            }
            CloseApproach ca4 = r3.get(0);
            // Building response
            List<CloseApproachDto> responseList = new ArrayList<>();
            responseList.add(getResponse(ca1,ca2));
            responseList.add(getResponse(ca2,ca4));
            return responseList;
        } catch (NoSuchElementException ex) {
            throw new IllegalArgumentException("Close approach data is not sufficient to find the required elements.", ex);
        }

    }

    private CloseApproachDto getResponse(CloseApproach from, CloseApproach to) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CloseApproachDto response = new CloseApproachDto();
        response.setFromPlanet(from.getOrbitingBody());
        response.setFromDate(dateFormat.format(from.getCloseApproachDate()));
        response.setToPlanet(to.getOrbitingBody());
        response.setToDate(dateFormat.format(to.getCloseApproachDate()));
        return response;
    }

}