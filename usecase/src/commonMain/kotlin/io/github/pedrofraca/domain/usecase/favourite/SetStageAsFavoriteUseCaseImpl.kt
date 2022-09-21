package io.github.pedrofraca.domain.usecase.favourite

import io.github.pedrofraca.domain.model.RateableStage
import io.github.pedrofraca.domain.usecase.favourite.repository.FavouritesRepository
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam

class SetStageAsFavoriteUseCaseImpl(private val repository: FavouritesRepository) : SetStageAsFavoriteUseCase {
    override fun invoke(param: SetStageAsFavoriteParam): Boolean {

       //TODO shall we include here the rest of our conditions.. like to only allow favs on finished stages
        return repository.getFavouriteStagesByUsername(param.username)
            .first { it.stageId == param.stageId }
            .let {
                //I've added this here since we said that our domain should contain the logic
                //But I don't like the fact we don't have an action over RateableStage which is the save method
                //It's not really transparent if the exception for a wrong state gets triggered whenever we create the
                //object
                RateableStage(param.stageId, it.username, it.favouriteState)
                repository.setFavouriteStage(it)
            }
    }
}