package jocture.strategy.service;

import jocture.strategy.data.Apple;

@FunctionalInterface
public interface ApplePredicate {

    // 추상 메서드 -> 구현 바디가 없는 메서드
    // 함수형 인터페이스 -> 추상 메서드가 하나인 인터페이스
    // (일반 용어로 추상 클래스라고 부르기도 하나 자바에서는 잘 구분해서 사용해야 함)
    boolean test(Apple apple);
}
