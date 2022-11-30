package racingcar.domain.Referee;

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
}
