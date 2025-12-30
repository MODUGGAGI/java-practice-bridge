package lotto.validator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeValidatorTest {

    @DisplayName("브릿지 길이 입력값 테스트")
    @Test
    void 브릿지_길이_정상_일때() {

        int bridgeSize = BridgeValidator.parseBridgeSize("15");

        assertThat(bridgeSize).isEqualTo(15);
    }

    @DisplayName("브릿지 길이 정수가 아닐 때")
    @Test
    void 브릿지_길이_정수_아닐때() {
        assertThatThrownBy(() -> BridgeValidator.parseBridgeSize("가나다"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 브릿지 길이는 정수만 가능합니다.");
    }

    @DisplayName("주어진 브릿지 길이를 벗어났을 때")
    @Test
    void 브릿지_길이_3미만_20초과_일때() {
        Assertions.assertThatThrownBy(() -> BridgeValidator.parseBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 브릿지 길이는 3이상 20이하만 가능합니다.");
    }

    @DisplayName("사용자의 다음 위치 입력이 U, D가 아닐 경우")
    @Test
    void 입력이_U_D가_아닐경우() {
        Assertions.assertThatThrownBy(() -> BridgeValidator.parseNextMove("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸은 U, D만 입력 가능합니다.");
    }

    @DisplayName("사용자의 다음 입력이 U, D로 정상 입력 됐을 경우")
    @Test
    void 입력이_U_D_인_경우() {
        int upperNextMove = BridgeValidator.parseNextMove("U");
        int lowerNextMove = BridgeValidator.parseNextMove("D");

        assertThat(upperNextMove).isEqualTo(1);
        assertThat(lowerNextMove).isEqualTo(0);
    }

    @DisplayName("재시도 커맨드 입력이 R, Q로 정상 입력 됐을 경우")
    @Test
    void 커맨드가_R_Q_일_경우() {
        boolean retry1 = BridgeValidator.parseCommand("R");
        boolean retry2 = BridgeValidator.parseCommand("Q");

        assertThat(retry1).isEqualTo(true);
        assertThat(retry2).isEqualTo(false);
    }

    @DisplayName("재시도 커맨드 입력이 R, Q가 아닐 경우")
    @Test
    void 커맨드가_R_Q_가_아닐_경우() {
        Assertions.assertThatThrownBy(() -> BridgeValidator.parseCommand("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 재시도 여부는 R, Q만 입력 가능합니다.");
    }
}