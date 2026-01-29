package com.example.demo.repository;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Booking.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByStatus(BookingStatus status);
    List<Booking> findByPassengerId(Long passengerId);
    List<Booking> findByRideId(Long rideId);
    List<Booking> findByRideIdAndStatus(Long rideId, BookingStatus status);
}
