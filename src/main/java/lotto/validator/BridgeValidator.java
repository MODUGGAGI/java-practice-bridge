package lotto.validator;

import lotto.message.ErrorMessage;

public class BridgeValidator {

    public static int parseBridgeSize(String bridgeSize) {
        try {
            int intBridgeSize =  Integer.parseInt(bridgeSize);
            validateSize(intBridgeSize);
            return intBridgeSize;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.toString());
        }
    }

    private static void validateSize(int intBridgeSize) {
        if (intBridgeSize < 3 || 20 < intBridgeSize) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_OUT_OF_RANGE.toString());
        }
    }

    public static int parseNextMove(String nextMove) {

        validateMove(nextMove);

        if (nextMove.equals("U")) {
            return 1;
        }

        return 0;
    }

    private static void validateMove(String nextMove) {
        if (!nextMove.equals("U") && !nextMove.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NEXT_MOVE.toString());
        }
    }

    public static boolean parseCommand(String command) {
        validateCommand(command);

        return command.equals("R");
    }

    private static void validateCommand(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.toString());
        }
    }
}
