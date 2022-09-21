package io.github.pedrofraca.domain.usecase.favourite.repository

data class SetStageAsFavoriteParam(
    private val username: String,
    private val stageId: String,
    private val favouriteState: Boolean
)
