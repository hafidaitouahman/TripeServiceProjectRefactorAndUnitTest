package com.test.service;

import com.tripservice.trip.Trip;
import com.tripservice.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class UserBuider {
        private User user;
        private List<User> friends = new ArrayList<>();
        private List<Trip> trips = new ArrayList<>();

        private UserBuider() {
        }

        public static UserBuider aUser() {
            return new UserBuider();
        }

        public UserBuider friendsWith(User... friends) {
            this.friends.addAll(Arrays.asList(friends));
            return this;
        }

        public UserBuider withTrips(Trip... trips) {
            this.trips.addAll(Arrays.asList(trips));
            return this;
        }

        public User build() {
            user = new User("Friend", "friend@email.com");
            addFriends(friends);
            addTrips(trips);
            return user;
        }

        private void addTrips(List<Trip> trips) {
            for (Trip trip : trips) {
                user.addTrip(trip);
            }
        }

        private void addFriends(List<User> friends) {
            for (User friend : friends) {
                user.addFriend(friend);
            }
        }
    }
