package com.tripservice.tripDAO;

import com.tripservice.common.DependedClassCallDuringUnitTestException;
import com.tripservice.user.User;
import org.junit.Test;

public class TripDAOTest {

    @Test(expected = DependedClassCallDuringUnitTestException.class)
    public void should_throw_exception_fwhen_retrieving_user_trips() throws DependedClassCallDuringUnitTestException {
        // Given a tripDAO
        new TripDAO().findTripsByUser(new User( "john", "John@gmail.com"  ));

    }
}
