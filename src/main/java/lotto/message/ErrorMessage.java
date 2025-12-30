package lotto.message;

public enum ErrorMessage {
    BRIDGE_SIZE_OUT_OF_RANGE("[ERROR] 브릿지 길이는 3이상 20이하만 가능합니다."),
    INVALID_BRIDGE_SIZE("[ERROR] 브릿지 길이는 정수만 가능합니다."),
    INVALID_NEXT_MOVE("[ERROR] 이동할 칸은 U, D만 입력 가능합니다."),
    INVALID_COMMAND("[ERROR] 게임 재시도 여부는 R, Q만 입력 가능합니다.")
    ;

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
