package io.github.pedrofraca.domain.mapper

import io.github.pedrofraca.domain.model.RateableStage
import io.github.pedrofraca.domain.model.Stage

class StageToRateableStageMapperImpl : StageToRateableMapper {
    override operator fun invoke(stage: Stage, username : String, fav : Boolean): RateableStage {
        if (stage.completed().not()) {
            throw IllegalStateException("Stage is not completed yet, therefore it can not be rated.")
        }
        return RateableStage(stage.stage, username, fav)
    }
}