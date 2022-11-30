package racingcar.domain.Referee;

import java.util.Map;

public class ResultDto {

    private static final String PREFIX = " : ";

    private final String resultDto;

    public ResultDto(Result result) {
        this.resultDto = translateResult(result);
    }

    public String getResultDto() {
        return resultDto;
    }

    private String translateResult(Result result) {
        Map<String, Integer> resultMap = result.getResult();
        StringBuilder translatedResult = new StringBuilder();
        for (String carName : resultMap.keySet()) {
            translatedResult.append(carName).append(PREFIX).append(renderPosition(resultMap.get(carName))).append("\n");
        }
        return translatedResult.toString();
    }

    private String renderPosition(Integer position) {
        return "-".repeat(position);
    }
}
