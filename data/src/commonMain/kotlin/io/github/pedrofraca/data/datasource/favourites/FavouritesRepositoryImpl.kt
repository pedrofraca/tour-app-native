package io.github.pedrofraca.data.datasource.favourites

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSource
import io.github.pedrofraca.data.datasource.WriteDataSourceWithFilter
import io.github.pedrofraca.domain.usecase.favourite.repository.FavouritesRepository
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam

class FavouritesRepositoryImpl(
    private val setFavouriteApi: WriteDataSource<SetStageAsFavoriteParam>,
    private val favouritesListApi: ReadOnlyDataSource<SetStageAsFavoriteParam>
) : FavouritesRepository {

    override fun setFavouriteStage(param: SetStageAsFavoriteParam) : Boolean {
        return setFavouriteApi.save(param)
    }

    override fun getFavouriteStagesByUsername(username: String): List<SetStageAsFavoriteParam> {
        return favouritesListApi.getAll()
    }
}