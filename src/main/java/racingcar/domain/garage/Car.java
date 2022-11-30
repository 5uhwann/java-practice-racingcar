package racingcar.domain.garage;

import static racingcar.domain.operator.Command.move;

public class Car {

    private final static int MAX_NAME_SIZE = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
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

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }


    public void move(int randomNumber) {
        if (move.getConditions().contains(randomNumber)) {
            position++;
        }
    }
}
