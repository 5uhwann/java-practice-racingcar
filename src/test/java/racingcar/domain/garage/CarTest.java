package racingcar.domain.garage;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.operator.Command.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"hwan", "pobi" })
    @DisplayName("5자 이하의 이름의 자동차는 생성 가능하다.")
    void successMakeCarTest(String carName) {
        //given //when
        Car car = new Car(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"suhwan", "pobipobi" })
    @DisplayName("5를 초과하의 이름의 자동차는 생성 불가능하다.")
    void failMakeCarTest(String carName) {
        //given //when //then
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(ints = {3,7,2,4})
    @DisplayName("자동차는 받은 입력 숫자에 따른 이동을 한다.")
    void moveTest(int randomNumber) {
        //given
        Car car = new Car("hwan");

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
