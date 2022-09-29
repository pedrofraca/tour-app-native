package io.github.pedrofraca.domain.usecase.favourite

import io.github.pedrofraca.data.datasource.favourites.SetStageAsFavoriteParam

interface SetStageAsFavoriteUseCase {
    fun invoke(param: SetStageAsFavoriteParam): Boolean
}