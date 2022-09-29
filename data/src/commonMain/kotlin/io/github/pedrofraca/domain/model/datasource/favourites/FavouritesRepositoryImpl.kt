package io.github.pedrofraca.data.datasource.favourites

import io.github.pedrofraca.data.datasource.ReadOnlyDataSourceWithFilter
import io.github.pedrofraca.data.datasource.WriteDataSource

class FavouritesRepositoryImpl(
    private val setFavouriteApi: WriteDataSource<SetStageAsFavoriteParam>,
    private val favouritesListApi: ReadOnlyDataSourceWithFilter<List<SetStageAsFavoriteParam>, String>
) : FavouritesRepository {

    override fun setFavouriteStage(param: SetStageAsFavoriteParam) : Boolean {
        return setFavouriteApi.save(param)
    }

    override fun getFavouriteStagesByUsername(username: String): List<SetStageAsFavoriteParam> {
        return favouritesListApi.get(username)
    }

    override fun getStageByUsername(stageId: Int, username: String): SetStageAsFavoriteParam? {
        return favouritesListApi.get(username).firstOrNull { it.stageId == stageId }
    }


}