package com.bus.booking.seat_selection_process.services;

import com.bus.booking.seat_selection_process.entity.Seat;
import com.bus.booking.seat_selection_process.entity.SeatStatus;
import com.bus.booking.seat_selection_process.repo.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    @Autowired
    private SeatRepo seatRepository;

    @KafkaListener(topics = "seat-unlock", groupId = "seat-group")
    public void unlockSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId).orElseThrow();
        if (seat.getStatus() == SeatStatus.LOCKED) {
            seat.setStatus(SeatStatus.AVAILABLE);
            seat.setLockExpiryTime(null);
            seatRepository.save(seat);
        }
    }

    @KafkaListener(topics = "seat-booked", groupId = "seat-group")
    public void bookSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId).orElseThrow();
        seat.setStatus(SeatStatus.BOOKED);
        seat.setLockExpiryTime(null);
        seatRepository.save(seat);
    }
}
