package com.tripservice.user;

import com.tripservice.service.UserBuider;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    private static final User BOB = new User("Bob", "bob@email.com");
    private static final User PAUL = new User("Paul", "paul@email.com");

    @Test
    public void should_inform_when_users_are_not_friends() {
     // Given a user and a friend
     User user = UserBuider.aUser()
                    .friendsWith(BOB)
                    .build();
     User friend = new User("Paul", "paul@email.com");


     // Then the users should not be friends
     assertThat(user.isFriendWith(PAUL), is(false));
    }

    @Test
    public void should_inform_when_users_are_friends() {
        // Given a user and a friend
        User user = UserBuider.aUser()
                   .friendsWith(BOB,PAUL)
                   .build();

        // Then the users should be friends
        assertThat(user.isFriendWith(PAUL), is(true));
    }
}
