package com.test.service;

import com.tripservice.common.UserNotLoggedInException;
import com.tripservice.service.TripService;
import com.tripservice.trip.Trip;
import com.tripservice.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.test.service.UserBuider.aUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TripServiceTest {

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User("a", "a@email.com");
    private static final User ANOTHER_USER = new User("b", "b@email.com");
    private static final Trip TO_BRAZIL = new Trip("TO BRASIL", 100, 10.0, 5, 6);
    private static final Trip TO_LONDON = new Trip("TO LONDON", 100, 10.0, 5, 6);
    private User loggedInUser;
    TripService tripService;
    List<Trip> friendTrips;

    @Before
    public void setup() {

        tripService = new TestableTripService();
    }
    @Test(expected = UserNotLoggedInException.class)
    public void
    should_throw_an_exception_when_user_is_not_logged_in() throws UserNotLoggedInException {

        loggedInUser = GUEST;
        tripService.getTrips(UNUSED_USER);

    }

    @Test()
    public void
    should_not_return_any_trip_when_users_are_not_friends() throws UserNotLoggedInException {
        loggedInUser = REGISTERED_USER;
        User friend = aUser()
                            .friendsWith(ANOTHER_USER)
                            .withTrips(TO_BRAZIL)
                            .build();
        friendTrips = tripService.getTrips(friend);
        //assert that friendTrips is empty
        assert friendTrips.isEmpty();
    }

    @Test
    public void
    should_return_friend_trips_list_when_users_are_friends() throws UserNotLoggedInException {
        loggedInUser = REGISTERED_USER;
        User friend = aUser()
                            .friendsWith(ANOTHER_USER, loggedInUser)
                            .withTrips(TO_BRAZIL,TO_LONDON)
                            .build();

        List<Trip> friendTrips = tripService.getTrips(friend);
        //assert that friendTrips is empty
        assertThat(friendTrips.size(),is(2)) ;
    }

    private class TestableTripService extends TripService {

        @Override
        public List<Trip> getTripList(User user) {
            return user.getFriendTrips();
        }

        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }
    }

}

