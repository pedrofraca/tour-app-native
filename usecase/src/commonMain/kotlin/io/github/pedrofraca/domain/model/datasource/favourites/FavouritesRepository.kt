package io.github.pedrofraca.data.datasource.favourites


interface FavouritesRepository {

    /**
     * Set Stage as favourite for given userId
     */
    fun setFavouriteStage(param: SetStageAsFavoriteParam) : Boolean

    /**
     * returns id of Stages that user has liked
     */
    fun getFavouriteStagesByUsername(username: String) : List<SetStageAsFavoriteParam>

    fun getStageByUsername(stageId: Int, username: String) : SetStageAsFavoriteParam?

}