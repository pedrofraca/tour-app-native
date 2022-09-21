package io.github.pedrofraca.domain.usecase.favourite

import io.github.pedrofraca.domain.usecase.favourite.repository.FavouritesRepository
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam

class SetStageAsFavoriteUseCaseImpl(private val repository: FavouritesRepository) : SetStageAsFavoriteUseCase {
    override fun invoke(param: SetStageAsFavoriteParam): Boolean {
        return repository.setFavouriteStage(param)
    }
}