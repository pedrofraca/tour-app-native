package io.github.pedrofraca.domain.usecase.favourite.repository

data class SetStageAsFavoriteParam(
    private val stageId: String,
    private val favouriteState: Boolean
)
