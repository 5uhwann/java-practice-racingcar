package racingcar.domain.Referee;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {

    private final Map<String, Integer> result;


    public Result(Map<String, Integer> result) {
        this.result = new LinkedHashMap<>(result);
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
