package io.github.pedrofraca.domain.usecase.stage

import io.github.pedrofraca.domain.model.Stage

interface GetStagesUseCase {
    operator fun invoke(): List<Stage>
}