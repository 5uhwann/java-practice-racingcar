package racingcar.domain.operator;

import java.util.List;
import racingcar.domain.garage.Car;
import racingcar.domain.garage.Cars;

public class OperatorImpl implements Operator{

    @Override
    public void orderMove(Cars cars) {
        List<Car> movingCars = cars.getCars();
        for (Car movingCar : movingCars) {
            movingCar.move(RandomNumberGenerator.generateRandomNumber());
        }
    }
}
