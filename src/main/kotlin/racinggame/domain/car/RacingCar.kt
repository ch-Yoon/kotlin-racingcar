package racinggame.domain.car

import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.factory.RacingCarUniqueKey
import racinggame.domain.car.engine.Engine
import racinggame.domain.car.system.RacingCarSystem
import racinggame.domain.player.Racer

class RacingCar(
    val uniqueKey: RacingCarUniqueKey,
    engine: Engine,
) {

    var onWheelsSpinListener: ((DrivableDistance) -> Unit)? = null

    private val racingCarSystem = RacingCarSystem(
        engine = engine,
        moveAction = { drivableDistance -> onWheelsSpinListener?.invoke(drivableDistance) }
    )

    var racer: Racer? = null
        private set

    fun getIn(racer: Racer) {
        getOffRacer()
        racer.connect(racingCarSystem)
        this.racer = racer
    }

    fun getOffRacer(): Racer? {
        racer?.disconnectRacingCarSystem()
        return racer.also { racer = null }
    }
}
