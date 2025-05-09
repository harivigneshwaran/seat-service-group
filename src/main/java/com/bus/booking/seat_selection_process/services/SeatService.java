package com.bus.booking.seat_selection_process.services;

import com.bus.booking.seat_selection_process.dto.SeatLockRequest;
import com.bus.booking.seat_selection_process.dto.SeatLockResponse;
import com.bus.booking.seat_selection_process.entity.Seat;
import com.bus.booking.seat_selection_process.entity.SeatStatus;
import com.bus.booking.seat_selection_process.repo.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SeatService {
    @Autowired
    private SeatRepo seatRepository;

    @Autowired
    private KafkaProducerService kafkaProducer;

    public String lockSeats(List<String> seatIds) {
        System.out.println("lockSeats Serv---->"+seatIds);

        for (String seatId : seatIds) {
            System.out.println("for loop Serv---->"+seatId);

            Optional<Seat> seatOpt = seatRepository.findById(Long.parseLong(seatId));
            System.out.println("seatOpt isPresent--->"+seatOpt.isPresent());
            if (seatOpt.isPresent()) {
                Seat seat = seatOpt.get();
                if (seat.getStatus() == SeatStatus.AVAILABLE) {
                    seat.setStatus(SeatStatus.LOCKED);
                    seat.setLockExpiryTime(LocalDateTime.now().plusMinutes(10));
                    seatRepository.save(seat);
                    kafkaProducer.sendSeatLockEvent(seatId);
                }
            }
        }
        return "Seats locked successfully.";
    }
}
