package io.github.pedrofraca.data.datasource.favourites

data class SetStageAsFavoriteParam(
    val username: String,
    val stageId: Int,
    val favouriteState: Boolean
)
