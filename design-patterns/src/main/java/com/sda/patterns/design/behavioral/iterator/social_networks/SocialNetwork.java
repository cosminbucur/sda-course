package com.sda.patterns.design.behavioral.iterator.social_networks;

import com.sda.patterns.design.behavioral.iterator.iterators.ProfileIterator;

public interface SocialNetwork {

    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
