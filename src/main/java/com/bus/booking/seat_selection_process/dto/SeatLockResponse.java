package com.bus.booking.seat_selection_process.dto;

public class SeatLockResponse {
    private Long seatId;
    private boolean locked;

    public Long getSeatId() {
        return seatId;
    }

    public SeatLockResponse(Long seatId, boolean locked) {
        this.seatId = seatId;
        this.locked = locked;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;


    }
}
