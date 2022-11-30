package racingcar.domain.garage;

import java.util.ArrayList;
import java.util.List;

public class GarageImpl implements Garage{

    @Override
    public Cars makeCars(String carNamesInput) throws IllegalArgumentException{
        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }
}
