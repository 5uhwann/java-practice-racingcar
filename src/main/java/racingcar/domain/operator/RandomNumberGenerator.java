package racingcar.domain.operator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

}
