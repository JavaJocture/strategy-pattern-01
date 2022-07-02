package jocture.strategy.service;

import jocture.strategy.data.Apple;
import jocture.strategy.data.Color;
import jocture.strategy.util.AppleUtils;

import java.util.ArrayList;
import java.util.List;

public class AppleFilter {

    // 핵심 로직 1
    public static List<Apple> filterApples1(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }

    // 핵심 로직 2
    public static List<Apple> filterApples2(List<Apple> apples, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }

    // 핵심 로직 3
    public static List<Apple> filterApples3(List<Apple> apples, Color color, int minWeight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor() == color && apple.getWeight() >= minWeight) {
                result.add(apple);
            }
        }
        return result;
    }

    // 핵심 로직 4
    public static List<Apple> filterApples4(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = AppleUtils.getRandomApples(100);

        // 메인 로직 테스트
        // 1. 하드 코딩
        System.out.println("result1 ---------------------");
        List<Apple> result1 = AppleFilter.filterApples1(apples);
        printApples(result1);
        // 2. 외부에서 파라미터로 전달
        System.out.println("result2 ---------------------");
        List<Apple> result2 = AppleFilter.filterApples2(apples, Color.BLACK);
        printApples(result2);
        // 3. 요구사항 추가 -> 무게로도 필터하고 싶다.
        System.out.println("result3 ---------------------");
        List<Apple> result3 = AppleFilter.filterApples3(apples, Color.RED, 200);
        printApples(result3);
        // 4. 동작(행동) 파라미터화(Behavior Parameterize) -> 전략 패턴(Strategy Pattern)
        System.out.println("result4 ---------------------");
        List<Apple> result4 = AppleFilter.filterApples4(apples, new GreenApplePredicate());
        printApples(result4);
        // 5. 익명 (구현) 클래스 방식
        System.out.println("result5 ---------------------");
        List<Apple> result5 = AppleFilter.filterApples4(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == Color.YELLOW;
            }
        });
        printApples(result5);

        // 6. 람다(표현)식 방식
        // (Java 1.8 이상일 때만 가능 or 함수형 인터페이스일 때만 가능)
        System.out.println("result6 ---------------------");

        // 장점 : 비즈니스 의미를 클래스명으로 표현 가능, 재사용 가능
        // 단점 : 클래스를 만들어야 한다.
        List<Apple> result6_1 = AppleFilter.filterApples4(apples, new HotGoodsApplePredicate());
        printApples(result6_1);

        // 장점 : 클래스를 만들지 않아도 된다.
        // 단점 : 재사용 불가능, 비즈니스 의미를 알기 어렵다.
        List<Apple> result6_2 = AppleFilter.filterApples4(apples, apple -> {
            return (apple.getColor() == Color.RED && apple.getWeight() >= 180)
                    || (apple.getColor() == Color.BLUE && apple.getWeight() >= 220);
        });
        printApples(result6_2);
    }

    private static void printApples(List<Apple> apples) {
        for (Apple apple : apples) {
            System.out.println(">>> apple = " + apple);
        }
        System.out.println(">>> apples.size() = " + apples.size());
    }
}
