package lotto.service;

import java.util.ArrayList;
import lotto.domain.BridgeGame;

public class BridgeMaker {

    public BridgeGame makeBridge(int intBridgeSize) {

        ArrayList<Integer> bridge = new ArrayList<>();

        for (int i = 0; i < intBridgeSize; i++) {
            bridge.add(BridgeRandomNumberGenerator.randomBridgeNumber());
        }

        return new BridgeGame(bridge);
    }
}
