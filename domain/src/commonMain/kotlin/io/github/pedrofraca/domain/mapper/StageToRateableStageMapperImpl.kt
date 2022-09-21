package io.github.pedrofraca.domain.mapper

import io.github.pedrofraca.domain.model.RateableStage
import io.github.pedrofraca.domain.model.StageModel

class StageToRateableStageMapperImpl : StageToRateableMapper {
    override operator fun invoke(stageModel: StageModel): RateableStage {
        if (stageModel.completed().not()) {
            throw IllegalStateException("Stage is not completed yet, therefore it can not be created.")
        }
        return RateableStage(stageModel.stage, "TODO", false)
    }
}