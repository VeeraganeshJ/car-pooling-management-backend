package com.example.demo.service;

import com.example.demo.entity.Ride;
import com.example.demo.entity.Ride.RideStatus;
import com.example.demo.entity.User;
import com.example.demo.repository.RideRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RideService {
    private final RideRepository rideRepository;
    private final UserRepository userRepository;

    public Ride createRide(Ride ride) {
        User driver = userRepository.findById(ride.getDriver().getId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        ride.setDriver(driver);
        return rideRepository.save(ride);
    }

    public Optional<Ride> getRideById(Long id) {
        return rideRepository.findById(id);
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public List<Ride> getRidesByStatus(RideStatus status) {
        return rideRepository.findByStatus(status);
    }

    public List<Ride> getRidesByLocation(String startingLocation, String destination) {
        return rideRepository.findByStartingLocationAndDestination(startingLocation, destination);
    }

    public List<Ride> getRidesByDriverId(Long driverId) {
        return rideRepository.findByDriverId(driverId);
    }

    public List<Ride> getRidesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return rideRepository.findByDepartureTimeBetween(startDate, endDate);
    }

    public Ride updateRide(Long id, Ride rideDetails) {
        Ride ride = rideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found with id: " + id));

        if (rideDetails.getStartingLocation() != null) {
            ride.setStartingLocation(rideDetails.getStartingLocation());
        }
        if (rideDetails.getDestination() != null) {
            ride.setDestination(rideDetails.getDestination());
        }
        if (rideDetails.getDepartureTime() != null) {
            ride.setDepartureTime(rideDetails.getDepartureTime());
        }
        if (rideDetails.getAvailableSeats() != null) {
            ride.setAvailableSeats(rideDetails.getAvailableSeats());
        }
        if (rideDetails.getPricePerSeat() != null) {
            ride.setPricePerSeat(rideDetails.getPricePerSeat());
        }
        if (rideDetails.getDescription() != null) {
            ride.setDescription(rideDetails.getDescription());
        }
        if (rideDetails.getStatus() != null) {
            ride.setStatus(rideDetails.getStatus());
        }

        return rideRepository.save(ride);
    }

    public void deleteRide(Long id) {
        if (!rideRepository.existsById(id)) {
            throw new RuntimeException("Ride not found with id: " + id);
        }
        rideRepository.deleteById(id);
    }

    public void updateRideStatus(Long id, RideStatus status) {
        Ride ride = rideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ride not found with id: " + id));
        ride.setStatus(status);
        rideRepository.save(ride);
    }
}
