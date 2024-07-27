package com.tripservice.service;

import com.tripservice.common.DependedClassCallDuringUnitTestException;
import com.tripservice.common.UserNotLoggedInException;
import com.tripservice.trip.Trip;
import com.tripservice.tripDAO.TripDAO;
import com.tripservice.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.tripservice.service.UserBuider.aUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User("a", "a@email.com");
    private static final User ANOTHER_USER = new User("b", "b@email.com");
    private static final Trip TO_BRAZIL = new Trip("TO BRASIL", 100, 10.0, 5, 6);
    private static final Trip TO_LONDON = new Trip("TO LONDON", 100, 10.0, 5, 6);
    private User loggedInUser;
    @Mock private TripDAO tripDAO;
    @InjectMocks
    private TripService tripService;
    List<Trip> friendTrips;


    @Test(expected = UserNotLoggedInException.class)
    public void
    should_throw_an_exception_when_user_is_not_logged_in() throws UserNotLoggedInException, DependedClassCallDuringUnitTestException {
        tripService.getTrips(UNUSED_USER,GUEST );
    }

    @Test()
    public void
    should_not_return_any_trip_when_users_are_not_friends() throws UserNotLoggedInException, DependedClassCallDuringUnitTestException {
        User friend = aUser()
                            .friendsWith(ANOTHER_USER)
                            .withTrips(TO_BRAZIL)
                            .build();
        friendTrips = tripService.getTrips(friend,REGISTERED_USER );
        //assert that friendTrips is empty
       assertThat( friendTrips.size(),is(0))  ;
    }

    @Test()
    public void
    should_return_friend_trips_list_when_users_are_friends() throws UserNotLoggedInException, DependedClassCallDuringUnitTestException {
        User friend = aUser()
                            .friendsWith(ANOTHER_USER, REGISTERED_USER)
                            .withTrips(TO_BRAZIL,TO_LONDON)
                            .build();

        given(tripDAO.findTripsByUser(friend)).willReturn(friend.getFriendTrips());
        List<Trip> friendTrips = tripService.getTrips(friend,REGISTERED_USER );
        //assert that friendTrips is empty
        assertThat(friendTrips.size(),is(2)) ;
    }


}

