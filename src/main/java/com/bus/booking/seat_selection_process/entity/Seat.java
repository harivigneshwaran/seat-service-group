package com.bus.booking.seat_selection_process.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Seat {
    @Id
    private Long id;
    private Long busId;
    private Long seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
    private LocalDateTime lockExpiryTime;

    public LocalDateTime getLockExpiryTime() {
        return lockExpiryTime;
    }

    public void setLockExpiryTime(LocalDateTime lockExpiryTime) {
        this.lockExpiryTime = lockExpiryTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Long getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Long seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
