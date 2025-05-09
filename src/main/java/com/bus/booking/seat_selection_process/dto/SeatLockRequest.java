package com.bus.booking.seat_selection_process.dto;

public class SeatLockRequest {

    private Long seatId;
    private Long userId;

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
