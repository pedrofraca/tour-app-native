package io.github.pedrofraca.domain.usecase.favourite.repository


interface FavouritesRepository {

    /**
     * Set Stage as favourite for given userId
     */
    fun setFavouriteStage(param: SetStageAsFavoriteParam) : Boolean

    /**
     * returns id of Stages that user has liked
     */
    fun getFavouriteStagesByUserId(userId: String) : List<String>

}