package jocture.strategy.service;

import jocture.strategy.data.Apple;

public class HeavyApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() >= 200;
    }
}
