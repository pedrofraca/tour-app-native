package io.github.pedrofraca.domain.mapper

import io.github.pedrofraca.domain.model.RatetableStage
import io.github.pedrofraca.domain.model.StageModel

interface StageToRatetableStageMapper {
    fun invoke(stageModel: StageModel): RatetableStage

}
