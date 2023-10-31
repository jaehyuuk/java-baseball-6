package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int NUMBER_SIZE = 3;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 9;

    private List<Integer> computerNumber;

    public void setComputerNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public Score getScore(List<Integer> input) {
        Score score = new Score();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int num = input.get(i);
            if (computerNumber.get(i).equals(num)) score.addStrike();
            else if (computerNumber.contains(num)) score.addBall();
        }
        return score;
    }
}
