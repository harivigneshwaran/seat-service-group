package com.bus.booking.seat_selection_process.repo;

import com.bus.booking.seat_selection_process.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends JpaRepository<Seat,Long> {
}
