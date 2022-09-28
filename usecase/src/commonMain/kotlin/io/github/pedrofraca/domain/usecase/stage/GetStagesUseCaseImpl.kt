package io.github.pedrofraca.domain.usecase.stage

import io.github.pedrofraca.domain.model.Stage
import io.github.pedrofraca.domain.usecase.stage.repository.StageRepository

class GetStagesUseCaseImpl(private val repository: StageRepository) : GetStagesUseCase {
    override fun invoke(): List<Stage> {
        return repository.stages
    }
}