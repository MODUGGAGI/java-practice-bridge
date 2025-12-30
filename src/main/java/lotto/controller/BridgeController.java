package lotto.controller;

import lotto.domain.BridgeGame;
import lotto.service.BridgeMaker;
import lotto.validator.BridgeValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BridgeController {

    private BridgeGame bridgeGame;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker();

    public void startGame() {
        String bridgeSize = inputView.readBridgeSize();
        int intBridgeSize = BridgeValidator.parseBridgeSize(bridgeSize);

        bridgeGame = bridgeMaker.makeBridge(intBridgeSize);

        boolean complete = false;
        int gameCount = 0;

        while (!complete) {
            gameCount++;
            // false면 중간에 틀렸다는 이야기.
            // true면 다 맞췄다는 이야기.
            complete = process(intBridgeSize);

            if (!complete) {
                // 재시도 여부 입력
                boolean retry = readGameCommand();

                // 재시도 여부가 true면 complete 그대로(false), false면 complete를 true로(종료)
                complete = isComplete(retry, complete);
                bridgeGame.gameSet();
            }
        }

        boolean success = bridgeGame.checkSuccess();

        outputView.printResult(bridgeGame.printResult(), success, gameCount);

    }

    private boolean isComplete(boolean retry, boolean complete) {
        if (!retry) {
            complete = true;
        }
        return complete;
    }

    private boolean process(int intBridgeSize) {
        boolean success = true;

        for (int i = 0; i < intBridgeSize; i++) {
            int nextMove = readMoving();

            String bridge = bridgeGame.drawBridge(nextMove);
            outputView.printBridge(bridge);

            if (!bridgeGame.checkAnswer(nextMove)) {
                success = false;
                break;
            }

            bridgeGame.moveNextLocation();
        }

        return success;
    }

    private int readMoving() {
        try {
            String nextMove = inputView.readMoving();

            return BridgeValidator.parseNextMove(nextMove);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readMoving();
        }
    }

    private boolean readGameCommand() {
        try {
            String command = inputView.readGameCommand();

            return BridgeValidator.parseCommand(command);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readGameCommand();
        }
    }
}
