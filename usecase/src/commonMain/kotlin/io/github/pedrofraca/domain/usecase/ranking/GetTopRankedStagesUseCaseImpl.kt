package io.github.pedrofraca.domain.usecase.ranking

import io.github.pedrofraca.domain.model.RankeableStage
import io.github.pedrofraca.data.datasource.rankeablestage.RankeableStageRepository

class GetTopRankedStagesUseCaseImpl(private val repository: RankeableStageRepository) : GetTopRankedStagesUseCase {
    override fun invoke(): List<RankeableStage> {
        return repository.rankeableStages
    }
}