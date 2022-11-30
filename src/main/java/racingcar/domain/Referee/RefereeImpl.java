package racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.garage.Car;
import racingcar.domain.garage.Cars;

public class RefereeImpl implements Referee {

    private Result result;

    @Override
    public ResultDto makeResult(Cars cars) {
        List<Car> movedCars = cars.getCars();
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        for (Car movedCar : movedCars) {
            resultMap.put(movedCar.getName(), movedCar.getPosition());
        }
        result = new Result(resultMap);
        return new ResultDto(result);
    }

    @Override
    public FinalResult makeFinalResult() {
        Map<String, Integer> resultMap = result.getResult();
        int winnerPosition = getWinnerPosition(resultMap);

        List<String> winners = new ArrayList<>();
        for (String car : resultMap.keySet()) {
            if (resultMap.get(car) == winnerPosition) {
                winners.add(car);
            }
        }
        return new FinalResult(winners);
    }

    private int getWinnerPosition(Map<String, Integer> resultMap) {
        ArrayList<Integer> positions = new ArrayList<>(resultMap.values());
        positions.sort(Comparator.naturalOrder());
        return positions.get(positions.size() - 1);
    }
}
