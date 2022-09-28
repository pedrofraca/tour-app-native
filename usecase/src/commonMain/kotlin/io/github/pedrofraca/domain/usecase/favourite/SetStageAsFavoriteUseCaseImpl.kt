package io.github.pedrofraca.domain.usecase.favourite

import io.github.pedrofraca.domain.model.RateableStage
import io.github.pedrofraca.domain.usecase.favourite.repository.FavouritesRepository
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam
import io.github.pedrofraca.domain.usecase.stage.repository.StageRepository

class SetStageAsFavoriteUseCaseImpl(private val repository: FavouritesRepository,
                                    private val stageRepository: StageRepository) : SetStageAsFavoriteUseCase {
    override fun invoke(param: SetStageAsFavoriteParam): Boolean {

        return repository.getStageByUsername(param.stageId, param.username).let {
            if (it != null) {
                RateableStage(stageRepository.getStageById(it.stageId), it.username, it.favouriteState)
            }
            repository.setFavouriteStage(param)
        }
    }
}