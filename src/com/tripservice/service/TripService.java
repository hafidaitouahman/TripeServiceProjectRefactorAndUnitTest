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
        List<Trip> tripList = new ArrayList<>();
        // Implement logic to retrieve trips from the database
        User loggedUser = getLoggedUser();
        boolean isFriend = false; // Replace with actual check for user login status
        if( loggedUser != null) {
            for(User friend : user.getFriends()) {
                if(friend.equals(loggedUser)) {
                    isFriend = true;
                    break;
                }
            }
            if(isFriend){
                tripList = getTripList(user);
            }
            return tripList;
        }
        else
        {
            throw new UserNotLoggedInException("User not logged in");
        }
    }

    protected User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }

    protected List<Trip> getTripList(User user) {
        List<Trip> tripList;
        tripList = TripDAO.findTripsByUser(user);
        return tripList;
    }
}
