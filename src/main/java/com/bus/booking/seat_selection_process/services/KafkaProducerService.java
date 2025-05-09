package com.bus.booking.seat_selection_process.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendSeatLockEvent(String seatId) {
        kafkaTemplate.send("seat-lock", seatId);
    }

    public void sendSeatUnlockEvent(String seatId) {
        kafkaTemplate.send("seat-unlock", seatId);
    }

    public void sendSeatBookedEvent(String seatId) {
        kafkaTemplate.send("seat-booked", seatId);
    }
}
