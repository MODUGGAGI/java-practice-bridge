package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(new ArrayList<>(List.of(1, 0, 0)));
    }

    @DisplayName("다리 잘 그려지는지 확인")
    @Test
    public void 다리_정상() {
        //given

        //when
        bridgeGame.moveNextLocation();
        bridgeGame.moveNextLocation();
        bridgeGame.drawBridge(0);

        //then
        String result = bridgeGame.printResult();

        assertThat(result).contains("[ O |   |   ]\n"
                + "[   | O | O ]");
    }

    @DisplayName("다리 이동 중간 과정 확인")
    @Test
    public void 중간_다리_이동과정_확인() {
        //given

        //when
        bridgeGame.moveNextLocation();
        bridgeGame.drawBridge(0);

        //then
        String result = bridgeGame.printResult();

        assertThat(result).contains("[ O |   ]\n"
                + "[   | O ]");
    }

    @DisplayName("실패한 경우 확인")
    @Test
    public void 실패_경우_X_확인() {
        //given

        //when
        bridgeGame.moveNextLocation();
        bridgeGame.drawBridge(1);

        //then
        String result = bridgeGame.printResult();
        assertThat(result).contains("[ O | X ]\n"
                + "[   |   ]");
    }
}