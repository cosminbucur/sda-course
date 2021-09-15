package com.sda.patterns.design.behavioral.iterator.iterators;

import com.sda.patterns.design.behavioral.iterator.profile.Profile;

public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();
}
