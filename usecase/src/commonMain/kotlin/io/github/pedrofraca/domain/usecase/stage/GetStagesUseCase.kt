package io.github.pedrofraca.domain.usecase.stage

import io.github.pedrofraca.domain.model.StageModel

interface GetStagesUseCase {
    operator fun invoke(): List<StageModel>
}