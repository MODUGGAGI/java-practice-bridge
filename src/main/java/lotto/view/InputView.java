package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.InputMessage;

public class InputView {

    public String readBridgeSize() {
        System.out.println(InputMessage.GET_BRIDGE_SIZE);
        return Console.readLine();
    }

    public String readMoving() {
        System.out.println();
        System.out.println(InputMessage.GET_NEXT_ROUND);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println();
        System.out.println(InputMessage.GET_RETRY);
        return Console.readLine();
    }
}
