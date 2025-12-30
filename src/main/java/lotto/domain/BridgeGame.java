package lotto.domain;

import java.util.ArrayList;

public class BridgeGame {

    private final ArrayList<Integer> bridge;
    private int currentLocation = 0;
    private String lastResult;

    public BridgeGame(ArrayList<Integer> bridge) {
        this.bridge = bridge;
    }

    public boolean checkAnswer(int nextMove) {

        int currentAnswer = bridge.get(currentLocation);

        return nextMove == currentAnswer;
    }

    public String printResult() {
        return lastResult;
    }

    public void moveNextLocation() {
        currentLocation++;
    }

    public void gameSet() {
        currentLocation = 0;
    }

    public boolean checkSuccess() {
        return currentLocation == bridge.size();
    }

    public String drawBridge(int nextMove) {

        StringBuilder upperBridge = new StringBuilder();
        StringBuilder lowerBridge = new StringBuilder();

        upperBridge.append("[");
        lowerBridge.append("[");

        for (int i = 0; i <= currentLocation - 1; i++) {

            int answer = bridge.get(i);

            upperBridge.append(drawUpperBridge(answer)).append("|");
            lowerBridge.append(drawLowerBridge(answer)).append("|");
        }

        int currentAnswer = bridge.get(currentLocation);

        if (nextMove != currentAnswer) {

            drawIncorrectBridge(nextMove, upperBridge, lowerBridge);

            return lastResult = upperBridge + "\n" + lowerBridge;
        }

        upperBridge.append(drawUpperBridge(currentAnswer)).append("]");
        lowerBridge.append(drawLowerBridge(currentAnswer)).append("]");

        return lastResult = upperBridge + "\n" + lowerBridge;
    }

    private void drawIncorrectBridge(int parsedMove, StringBuilder upperBridge, StringBuilder lowerBridge) {
        if (parsedMove == 0) {
            upperBridge.append("   ").append("]");
            lowerBridge.append(" X ").append("]");
        }

        if (parsedMove == 1) {
            upperBridge.append(" X ").append("]");
            lowerBridge.append("   ").append("]");
        }
    }

    private String drawUpperBridge(int answer) {
        if (answer == 1) {
            return " O ";
        }

        return "   ";
    }

    private String drawLowerBridge(int answer) {
        if (answer == 0) {
            return " O ";
        }

        return "   ";
    }
}
