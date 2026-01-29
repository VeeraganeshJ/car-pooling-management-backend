package com.example.demo.repository;

import com.example.demo.entity.Ride;
import com.example.demo.entity.Ride.RideStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByStatus(RideStatus status);
    List<Ride> findByStartingLocationAndDestination(String startingLocation, String destination);
    List<Ride> findByDepartureTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Ride> findByDriverId(Long driverId);
}
