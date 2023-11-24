package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class RacingCar {
    private RaceService raceService;

    public void init() {
        raceService = new RaceService();
    }

    public void Run() {
        String userInput = InputView.getCarNames();
        raceService.setCars(userInput);
        userInput = InputView.getNumberOfRounds();
        raceService.setRounds(userInput);
        OutputView.printPrefaceOfResult();
        for (int round = 1; round <= raceService.getNumberOfRounds(); round++) {
            raceService.raceCars();
            OutputView.printResultOfRound(raceService.getCars());
        }
    }
}
