package jocture.strategy.service;

import jocture.strategy.data.Apple;
import jocture.strategy.data.Color;

public class HeavyOrWhiteApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor() == Color.WHITE || apple.getWeight() >= 200;
    }
}
