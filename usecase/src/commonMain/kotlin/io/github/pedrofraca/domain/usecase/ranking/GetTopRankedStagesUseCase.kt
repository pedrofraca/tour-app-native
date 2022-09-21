package io.github.pedrofraca.domain.usecase.ranking

import io.github.pedrofraca.domain.model.RankeableStage

interface GetTopRankedStagesUseCase {
    operator fun invoke(): List<RankeableStage>
}