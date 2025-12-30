package lotto.message;

public enum InputMessage {
    GET_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    GET_NEXT_ROUND("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GET_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    ;

    private final String description;

    InputMessage(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
