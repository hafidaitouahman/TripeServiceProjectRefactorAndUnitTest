package com.tripservice.user;

import com.tripservice.trip.Trip;

import java.util.ArrayList;
import java.util.List;


public class User {
    private String name;
    private String email;

    public List<Trip> getFriendTrips() {
        return friendTrips;
    }

    List<Trip> friendTrips = new ArrayList<>();
    List<User> friends = new ArrayList<>();
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public List<User> getFriends() {

        return friends;
    }

    public void addFriend(User registeredUser) {
        friends.add(registeredUser);
    }

    public void addTrip(Trip trip) {
        friendTrips.add(trip);
    }


    public Boolean isFriendWith(User user) {
        return friends.contains(user);
    }
}
