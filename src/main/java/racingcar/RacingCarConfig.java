package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.Referee.Referee;
import racingcar.domain.Referee.RefereeImpl;
import racingcar.domain.garage.Garage;
import racingcar.domain.garage.GarageImpl;
import racingcar.domain.operator.Operator;
import racingcar.domain.operator.OperatorImpl;

public class RacingCarConfig {

    public GameController gameController() {
        return new GameController(garage(), operator(), referee());
    }

    private Garage garage() {
        return new GarageImpl();
    }

    private Operator operator() {
        return new OperatorImpl();
    }

    private Referee referee() {
        return new RefereeImpl();
    }


}
