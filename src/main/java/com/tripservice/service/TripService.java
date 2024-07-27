package com.tripservice.service;

import com.tripservice.common.DependedClassCallDuringUnitTestException;
import com.tripservice.common.UserNotLoggedInException;
import com.tripservice.trip.Trip;
import com.tripservice.tripDAO.TripDAO;
import com.tripservice.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class TripService {

    @Autowired
    private TripDAO tripDAO;

    public TripDAO getTripDAO() {
        return tripDAO;
    }


    public List<Trip> getTrips(User user, User loggedInUser) throws UserNotLoggedInException, DependedClassCallDuringUnitTestException {

        // Implement logic to retrieve trips from the database
        validatLoggedInUser(loggedInUser);
        return user.isFriendWith(loggedInUser)
                ? getTripList(user)
                : noTrips();
    }

    private static void validatLoggedInUser(User loggedInUser) throws UserNotLoggedInException {
        if( loggedInUser == null) {
            throw new UserNotLoggedInException("User not logged in");
        }
    }

    private ArrayList<Trip> noTrips() {
        return new ArrayList<>();
    }
    private List<Trip> getTripList(User user) throws DependedClassCallDuringUnitTestException {
            return tripDAO.findTripsByUser(user);
    }
}
