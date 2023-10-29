package racingcar.gameLogic;

import java.util.List;
import racingcar.utils.InputValidator;
import racingcar.utils.StringChanger;
import racingcar.views.InputViewer;

public class User {
    public List<String> inputCarName() {
        String userInput = InputViewer.requestCarNameInput();
        return requestValidateCarNames(userInput);
    }

    public int inputNumberOfTry() {
        int numberOfTry;
        String userInput = InputViewer.requestNumberOfTry();
        userInput = StringChanger.stringToTrimmedString(userInput);
        numberOfTry = Integer.parseInt(userInput);
        return numberOfTry;

    }

    public List<String> requestValidateCarNames(String userInput) {
        List<String> carNameList = requestStringToList(userInput);

        InputValidator.validateNumberOfCars(carNameList.size());
        InputValidator.validateIsNamesDistinct(carNameList);
        for (String carName : carNameList) {
            InputValidator.validateNameLength(carName.length());
        }

        return carNameList;
    }

    public List<String> requestStringToList(String userInput) {
        return StringChanger.stringToStringList(userInput);
    }
}
