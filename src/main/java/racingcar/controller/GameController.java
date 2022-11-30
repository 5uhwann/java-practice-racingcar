package racingcar.controller;

import racingcar.domain.Referee.FinalResult;
import racingcar.domain.Referee.Referee;
import racingcar.domain.Referee.ResultDto;
import racingcar.domain.garage.Cars;
import racingcar.domain.garage.Garage;
import racingcar.domain.operator.Operator;
import racingcar.utils.ErrorMessage;
import racingcar.utils.OutputMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private static final String REGEX_NUMBER = "^[0-9]$";

    private final Garage garage;
    private final Operator operator;
    private final Referee referee;

    public GameController(Garage garage, Operator operator, Referee referee) {
        this.garage = garage;
        this.operator = operator;
        this.referee = referee;
    }

    public void runGame() {
        Cars cars;
        try {
            cars = garage.makeCars(requestCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            cars = garage.makeCars(requestCarNames());
        }

        String attemptCount = requestAttemptCount();
        validateAttemptCount(attemptCount);

        orderMoveAllCars(cars, attemptCount);

        noticeFinalResult();
    }

    private String requestCarNames() {
        OutputView.printMessage(OutputMessage.REQUEST_CAR_NAMES);
        return InputView.input();
    }

    private String requestAttemptCount() {
        OutputView.printMessage(OutputMessage.REQUEST_ATTEMPT_COUNT);
        return InputView.input();
    }

    private void validateAttemptCount(String attemptCount) {
        if (!attemptCount.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPT);
        }
    }

    private void orderMoveAllCars(Cars cars, String attemptCount) {
        for (int i = 0; i < Integer.parseInt(attemptCount); i++) {
            operator.orderMove(cars);
            ResultDto resultDto = referee.makeResult(cars);
            OutputView.printMessage(resultDto.getResultDto());
        }
    }

    private void noticeFinalResult() {
        FinalResult finalResult = referee.makeFinalResult();
        OutputView.printMessage(finalResult.getTranslatedWinners());
    }
}
