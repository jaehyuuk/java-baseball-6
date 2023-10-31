package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private static final String ONLY_THREE_ERROR_MESSAGE = "3개의 숫자만 입력하세요.";
    private static final String DUPLICATED_ERROR_MESSAGE = "중복되지 않은 숫자만 입력하세요.";
    private static final String NUMBER_ERROR_MESSAGE = "숫자가 아닌 값은 입력할 수 없습니다.";
    private static final String WRONG_INPUT_ERROR_MESSAGE = "1(재시작) 또는 2(종료)를 입력하세요.";

    public List<Integer> setPlayerNumber() throws IllegalArgumentException {
        String playerInput = Console.readLine();
        return playerInputToInteger(playerInput);
    }

    private List<Integer> playerInputToInteger(String playerInput) throws IllegalArgumentException {
        String[] split = playerInput.split("");
        if (split.length != 3) {
            throw new IllegalArgumentException(ONLY_THREE_ERROR_MESSAGE);
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(split[i]));
        }
        checkDuplicatedNumber(numbers);
        return numbers;
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> checkNumber = new HashSet<>();
        for (int num : numbers) {
            if (checkNumber.contains(num)) {
                throw new IllegalArgumentException(DUPLICATED_ERROR_MESSAGE);
            }
            checkNumber.add(num);
        }
    }

    public boolean restart() {
        String num = Console.readLine();
        return checkNumberException(num);
    }

    private boolean checkNumberException(String num) {
        try {
            int number = Integer.parseInt(num);
            if (number == 1) return true;
            if (number == 2) return false;
            throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }
}
