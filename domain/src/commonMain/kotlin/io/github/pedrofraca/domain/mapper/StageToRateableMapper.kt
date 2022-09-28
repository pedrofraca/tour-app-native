package io.github.pedrofraca.domain.mapper

import io.github.pedrofraca.domain.model.RateableStage
import io.github.pedrofraca.domain.model.Stage

interface StageToRateableMapper {
    fun invoke(stage: Stage, username : String, fav : Boolean): RateableStage
}
