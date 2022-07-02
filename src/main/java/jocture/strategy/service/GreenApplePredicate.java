package jocture.strategy.service;

import jocture.strategy.data.Apple;
import jocture.strategy.data.Color;

public class GreenApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor() == Color.GREEN;
    }
}
