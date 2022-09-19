package io.github.pedrofraca.domain.usecase.favourite

import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam

interface SetStageAsFavoriteUseCase {
    operator fun invoke(param: SetStageAsFavoriteParam)
}