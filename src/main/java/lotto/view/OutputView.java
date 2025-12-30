package lotto.view;

import lotto.message.OutputMessage;

public class OutputView {

    public void printBridge(String bridge) {
        System.out.println(bridge);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printResult(String result, boolean success, int gameCount) {

        System.out.println("\n" + OutputMessage.GAME_RESULT);
        System.out.println(result + "\n");

        String successOrNot = success ? OutputMessage.SUCCESS.toString() : OutputMessage.FAILURE.toString();

        System.out.println(successOrNot);

        System.out.println(OutputMessage.GAME_COUNT + String.valueOf(gameCount));
    }
}
