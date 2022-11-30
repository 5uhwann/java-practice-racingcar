package racingcar.domain.Referee;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    @Test
    @DisplayName("가장 앞선 자동차가 최종 우승한다.")
    void makeFinalResultTest_case1() {
        //given
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        resultMap.put("suhwan", 3);
        resultMap.put("pobi", 1);
        Result result = new Result(resultMap);

        //when
        FinalResult finalResult = referee.makeFinalResult(result);

        //then
        assertThat(finalResult.getTranslatedWinners()).isEqualTo("최종 우승자 : suhwan");

    }

    @Test
    @DisplayName("최종 우승자 중에 공동 우승자가 있을 수 있다.")
    void makeFinalResultTest_case2() {
        //given
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        resultMap.put("suhwan", 3);
        resultMap.put("pobi", 3);
        Result result = new Result(resultMap);

        //when
        FinalResult finalResult = referee.makeFinalResult(result);

        //then
        assertThat(finalResult.getTranslatedWinners()).isEqualTo("최종 우승자 : suhwan, pobi");

    }

}
