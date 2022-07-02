package jocture.strategy.data;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicReference;

public enum Color {
    RED, YELLOW, GREEN, BLUE, BLACK, WHITE;

    public static Color valueOfOrdinal(int ordinal) { // ordinal : 0~5
        EnumSet<Color> colors = EnumSet.allOf(Color.class);
        AtomicReference<Color> result = new AtomicReference<>(); // 참조형으로 변경 필요
        colors.forEach(color -> { // 무조건 6번 반복된다.
            if (color.ordinal() == ordinal) {
                result.set(color); // 람다 캡쳐링 주의
            }
        });
        return result.get();
    }
}
