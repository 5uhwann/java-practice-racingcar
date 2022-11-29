package racingcar.domain.operator;

import static racingcar.domain.operator.Command.*;

public class OperatorImpl implements Operator{

    @Override
    public Command makeCommand(int randomNumber) {
        if (move.getConditions().contains(randomNumber)) {
            return move;
        }
        return stop;
    }
}
