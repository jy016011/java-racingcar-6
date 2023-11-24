package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class RacingCar {
    private static final int FIRST_ROUND = 1;
    private RaceService raceService;

    public void init() {
        raceService = new RaceService();
    }

    public void Run() {
        getCarNames();
        getNumberOfRounds();
        printResult();
    }

    private void getCarNames() {
        String userInput = InputView.getCarNames();
        raceService.setCars(userInput);
    }

    private void getNumberOfRounds() {
        String userInput = InputView.getNumberOfRounds();
        raceService.setRounds(userInput);
    }

    private void printResult() {
        OutputView.printPrefaceOfResult();
        for (int round = FIRST_ROUND; round <= raceService.getNumberOfRounds(); round++) {
            raceService.raceCars();
            OutputView.printResultOfRound(raceService.getCars());
        }
        OutputView.printWinners(raceService.getWinners());
    }
}
