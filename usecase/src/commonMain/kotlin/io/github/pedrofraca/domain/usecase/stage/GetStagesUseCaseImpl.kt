package io.github.pedrofraca.domain.usecase.stage

import io.github.pedrofraca.data.datasource.stage.StageRepository
import io.github.pedrofraca.domain.model.Stage

class GetStagesUseCaseImpl(private val repository: StageRepository) : GetStagesUseCase {
    override fun invoke(): List<Stage> {
        return repository.stages
    }
}