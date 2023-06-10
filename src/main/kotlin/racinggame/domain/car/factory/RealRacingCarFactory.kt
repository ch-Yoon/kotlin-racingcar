package racinggame.domain.car.factory

import racinggame.domain.car.RacingCar
import racinggame.domain.car.engine.RandomEnergyEngine
import racinggame.domain.car.engine.RealRandomNumberGenerator

class RealRacingCarFactory : RacingCarFactory {

    private var version = 0

    override fun create(): RacingCar {
        return RacingCar(
            uniqueKey = RacingCarUniqueKey("$KEY_PREFIX${version++}"),
            engine = RandomEnergyEngine(RealRandomNumberGenerator())
        )
    }

    companion object {
        private const val KEY_PREFIX = "racingCar_"
    }
}
