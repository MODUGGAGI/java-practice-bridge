package lotto.message;

public enum OutputMessage {
    GAME_RESULT("최종 게임 결과"),
    SUCCESS("게임 성공 여부: 성공"),
    FAILURE("게임 성공 여부: 실패"),
    GAME_COUNT("총 시도한 횟수: ");

    private final String description;

    OutputMessage(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
