package racingcar.domain.Referee;

import racingcar.domain.garage.Cars;

public interface Referee {

    ResultDto makeResult(Cars cars);

    FinalResult makeFinalResult(Result result);


}
