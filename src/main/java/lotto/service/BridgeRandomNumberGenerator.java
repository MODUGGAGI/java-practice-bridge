package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

public class BridgeRandomNumberGenerator {

    public static int randomBridgeNumber() {
        return Randoms.pickNumberInRange(0, 1);
    }
}
