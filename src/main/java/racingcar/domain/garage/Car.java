package racingcar.domain.garage;

import static racingcar.domain.operator.Command.move;

import racingcar.utils.ErrorMessage;

public class Car {

    private final static int MAX_NAME_SIZE = 5;

    private final String name;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {
        validateCarName(name);
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCarName(String name) throws IllegalArgumentException {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME);
        }
    }


    public void move(int randomNumber) {
        if (move.getConditions().contains(randomNumber)) {
            position++;
        }
    }
}
