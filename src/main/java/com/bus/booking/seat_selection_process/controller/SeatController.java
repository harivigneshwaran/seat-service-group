package com.bus.booking.seat_selection_process.controller;

import com.bus.booking.seat_selection_process.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/lock")
    public ResponseEntity<String> lockSeats(@RequestBody List<String> seatIds) {
        System.out.println("Controller---->"+seatIds);
        return ResponseEntity.ok(seatService.lockSeats(seatIds));
    }
}
