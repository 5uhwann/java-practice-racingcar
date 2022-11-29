package racingcar.domain.garage;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GarageImplTest {

    @Test
    @DisplayName("차고는 차 이름들 만큼 차를 생성한다.")
    void makeCarsTest() {
        //given
        Garage garage = new GarageImpl();
        String carNamesInput = "pobi,suhwan";

        //when
        Cars cars = garage.makeCars(carNamesInput);

        //then
        assertThat(cars.getCars().size()).isEqualTo(carNamesInput.split(",").length);
    }

}
