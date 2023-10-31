package baseball;

public class Score {
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";

    private int strike = 0;
    private int ball = 0;

    @Override
    public String toString() {
        String result = NOTHING_MESSAGE;
        if (strike + ball != 0) {
            StringBuilder score = new StringBuilder();
            if (ball > 0) score.append(ball + BALL_MESSAGE);
            if (strike > 0) {
                if (!score.isEmpty()) score.append(" ");
                score.append(strike + STRIKE_MESSAGE);
            }
            result = score.toString();
        }
        return result;
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public boolean isThreeStrike() {
        if (strike == 3) return true;
        else             return false;
    }

}
