package racingcar.domain.operator;

import java.util.Arrays;
import java.util.List;

public enum Command {
    move(Arrays.asList(4, 5, 6, 7, 8, 9)),
    stop(Arrays.asList(1, 2, 3));

    private final List<Integer> conditions;

    Command(List<Integer> conditions) {
        this.conditions = conditions;
    }

    public List<Integer> getConditions() {
        return conditions;
    }
}
