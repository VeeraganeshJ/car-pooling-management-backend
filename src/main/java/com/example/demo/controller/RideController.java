package com.example.demo.controller;

import com.example.demo.entity.Ride;
import com.example.demo.entity.Ride.RideStatus;
import com.example.demo.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rides")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class RideController {
    private final RideService rideService;

    @PostMapping
    public ResponseEntity<?> createRide(@Valid @RequestBody Ride ride) {
        try {
            Ride createdRide = rideService.createRide(ride);
            return new ResponseEntity<>(createdRide, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(java.util.Map.of("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Ride>> getAllRides() {
        List<Ride> rides = rideService.getAllRides();
        return new ResponseEntity<>(rides, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable Long id) {
        return rideService.getRideById(id)
                .map(ride -> new ResponseEntity<>(ride, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Ride>> getRidesByStatus(@PathVariable RideStatus status) {
        List<Ride> rides = rideService.getRidesByStatus(status);
        return new ResponseEntity<>(rides, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Ride>> searchRides(
            @RequestParam String startingLocation,
            @RequestParam String destination) {
        List<Ride> rides = rideService.getRidesByLocation(startingLocation, destination);
        return new ResponseEntity<>(rides, HttpStatus.OK);
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<Ride>> getRidesByDriver(@PathVariable Long driverId) {
        List<Ride> rides = rideService.getRidesByDriverId(driverId);
        return new ResponseEntity<>(rides, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRide(@PathVariable Long id, @Valid @RequestBody Ride rideDetails) {
        try {
            Ride updatedRide = rideService.updateRide(id, rideDetails);
            return new ResponseEntity<>(updatedRide, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(java.util.Map.of("error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateRideStatus(@PathVariable Long id, @RequestParam RideStatus status) {
        try {
            rideService.updateRideStatus(id, status);
            return new ResponseEntity<>(java.util.Map.of("message", "Status updated successfully"), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(java.util.Map.of("error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRide(@PathVariable Long id) {
        try {
            rideService.deleteRide(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(java.util.Map.of("error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
