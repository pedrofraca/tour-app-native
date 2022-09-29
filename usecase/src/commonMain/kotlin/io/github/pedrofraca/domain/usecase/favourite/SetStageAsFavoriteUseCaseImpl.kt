package io.github.pedrofraca.domain.usecase.favourite

import io.github.pedrofraca.data.datasource.favourites.FavouritesRepository
import io.github.pedrofraca.data.datasource.stage.StageRepository
import io.github.pedrofraca.domain.model.RateableStage
import io.github.pedrofraca.data.datasource.favourites.SetStageAsFavoriteParam

open class SetStageAsFavoriteUseCaseImpl(private val repository: FavouritesRepository,
                                         private val stageRepository: StageRepository
) : SetStageAsFavoriteUseCase {
    override fun invoke(param: SetStageAsFavoriteParam): Boolean {

        return repository.getStageByUsername(param.stageId, param.username).let {
            if (it != null) {
                RateableStage(stageRepository.getStageById(it.stageId), it.username, it.favouriteState)
            }
            repository.setFavouriteStage(param)
        }
    }
}