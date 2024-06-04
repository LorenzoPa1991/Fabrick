package com.fabrick.demo.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabrick.demo.dto.CloseApproachDto;
import com.fabrick.demo.service.AsteroidService;

@RequestMapping(value = "/api/fabrick/v1.0")
@Controller
public class AsteroidController {

    @Autowired
    private AsteroidService asteroidService;

    @GetMapping(value = "/asteroids/{asteroidId}")
    public ResponseEntity<List<CloseApproachDto>> getAsteroid(@PathVariable Integer asteroidId,
                                                              @RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                                              @RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
        if (fromDate == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -100);
            fromDate = calendar.getTime();
        }
        if (toDate == null) {
            Calendar calendar = Calendar.getInstance();
            toDate = calendar.getTime();
        }
        return ResponseEntity.ok(asteroidService.getCloseApproach(asteroidId, fromDate,toDate));
    }

}