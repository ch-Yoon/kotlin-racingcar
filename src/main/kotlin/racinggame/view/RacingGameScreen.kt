package racinggame.view

import racinggame.domain.RealRacingGame
import racinggame.domain.car.factory.RealRacingCarFactory

fun startRacingGameScreen() {
    RacingGameController(
        inputView = RealRacingGameInputView(),
        outputView = RealRacingGameOutputView(),
        racingGame = RealRacingGame(
            racingCarFactory = RealRacingCarFactory(),
        ),
    ).start()
}
