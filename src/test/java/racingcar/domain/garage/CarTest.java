package racingcar.domain.garage;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.operator.Command.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {3,7,2,4})
    @DisplayName("자동차는 받은 입력 숫자에 따른 이동을 한다.")
    void moveTest(int randomNumber) {
        //given
        Car car = new Car("suhwan");

        //when
        car.move(randomNumber);

        //then
        if (move.getConditions().contains(randomNumber)) {
            assertThat(car.getPosition()).isEqualTo(1);
            return;
        }
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
