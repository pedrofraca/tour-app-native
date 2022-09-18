package io.github.pedrofraca.domain.mapper

import io.github.pedrofraca.domain.model.RateableStage
import io.github.pedrofraca.domain.model.StageModel

interface StageToRateableMapper {
    fun invoke(stageModel: StageModel): RateableStage
}
