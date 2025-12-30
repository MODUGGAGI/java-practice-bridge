package lotto;

import lotto.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController controller = new BridgeController();
        controller.startGame();
    }
}
