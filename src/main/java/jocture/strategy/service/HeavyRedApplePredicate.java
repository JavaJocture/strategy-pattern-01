package jocture.strategy.service;

import jocture.strategy.data.Apple;
import jocture.strategy.data.Color;

public class HeavyRedApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor() == Color.RED && apple.getWeight() >= 200;
    }
}
