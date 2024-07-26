package com.tripservice.service;

import com.tripservice.common.UserNotLoggedInException;
import com.tripservice.trip.Trip;
import com.tripservice.tripDAO.TripDAO;
import com.tripservice.user.User;
import com.tripservice.web.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {
    public List<Trip> getTrips(User user) throws UserNotLoggedInException {

        // Implement logic to retrieve trips from the database
        User loggedInUser = getLoggedInUser();
        if( loggedInUser == null) {
            throw new UserNotLoggedInException("User not logged in");
        }
        return user.isFriendWith(loggedInUser)
                ? getTripList(user)
                : noTrips();
    }

    private static ArrayList<Trip> noTrips() {
        return new ArrayList<>();
    }

    protected User getLoggedInUser() {
        return UserSession.getInstance().getLoggedUser();
    }

    protected List<Trip> getTripList(User user) {
        return TripDAO.findTripsByUser(user);
    }
}
