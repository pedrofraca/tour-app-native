package io.github.pedrofraca.domain.mapper

import io.github.pedrofraca.domain.model.RatetableStage
import io.github.pedrofraca.domain.model.StageClassificationModel
import io.github.pedrofraca.domain.model.StageModel

class StageToRatetableStageMapperImpl : StageToRatetableStageMapper {
    override operator fun invoke(stageModel: StageModel): RatetableStage {
        if (stageModel.completed().not()) {
            throw IllegalStateException("Stage is not completed yet, therefore it can not be created.")
        }
        return RatetableStage(stageModel.name)
    }
}