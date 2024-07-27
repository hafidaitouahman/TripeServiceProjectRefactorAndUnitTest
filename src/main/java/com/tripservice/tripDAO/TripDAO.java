package com.tripservice.tripDAO;

import com.tripservice.common.DependedClassCallDuringUnitTestException;
import com.tripservice.trip.Trip;
import com.tripservice.user.User;

import java.util.List;

public class TripDAO {
    // Implement methods to interact with the Trip database
    // e.g., create, read, update, delete (CRUD) operations
    // and handle exceptions for database operations
    // (e.g., connection failures, invalid queries, etc.)

    public void createTrip(Trip trip) {
        // Implement code to create a new trip in the database
    }

    public Trip readTripById(int id) {
        // Implement code to read a trip from the database by its ID
        return null; // Placeholder return value
    }

    public void updateTrip(Trip trip) {
        // Implement code to update an existing trip in the database
    }

    public void deleteTrip(int id) {
        // Implement code to delete a trip from the database by its ID
    }

    // Add more methods as needed
    public List<Trip> findTripsByUser(User user) throws DependedClassCallDuringUnitTestException {
        // Implement code to find trips by a user in the database
        throw new DependedClassCallDuringUnitTestException("TripDAO should not be invoked on an  unit test."); // Placeholder return value
    }
}
