package racingcar.domain.Referee;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.garage.Car;
import racingcar.domain.garage.Cars;

class RefereeImplTest {

    private static final Referee referee = new RefereeImpl();

    @Test
    @DisplayName("움직인 차의 결과를 생성한다.")
    void makeResultTest_Moving() {
        //given
        Car car = new Car("suhwan");
        car.move(6);
        Cars cars = new Cars(List.of(car));

        //when
        ResultDto resultDto = referee.makeResult(cars);

        //then
        String result = resultDto.getResultDto();
        assertThat(result).contains("suhwan : ", "-");

    }

    @Test
    @DisplayName("움직이지 않은 차의 결과를 생성한다.")
    void makeResultTest_Stopping() {
        //given
        Car car = new Car("suhwan");
        car.move(2);
        Cars cars = new Cars(List.of(car));

        //when
        ResultDto resultDto = referee.makeResult(cars);

        //then
        String result = resultDto.getResultDto();
        assertThat(result).contains("suhwan : ");
        assertThat(result).doesNotContain("-");

    }

}
