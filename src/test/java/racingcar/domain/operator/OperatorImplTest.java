package racingcar.domain.operator;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.operator.Command.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorImplTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 1, 3})
    @DisplayName("이동 명령 커맨드 조건에 해당되는 커맨드가 생성된다.")
    void makeCommandTest(int randomNumber) {
        //given
        Operator operator = new OperatorImpl();

        //when
        Command command = operator.makeCommand(randomNumber);

        //then
        if (move.getConditions().contains(randomNumber)) {
            assertThat(command).isEqualTo(move);
            return;
        }
        assertThat(command).isEqualTo(stop);

    }

}
