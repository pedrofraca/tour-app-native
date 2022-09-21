package io.github.pedrofraca.domain.usecase.favourite.repository

data class SetStageAsFavoriteParam(
    val username: String,
    val stageId: Int,
    val favouriteState: Boolean
)
