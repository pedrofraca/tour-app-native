package io.github.pedrofraca.data.datasource.favourites

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSourceWithFilter
import io.github.pedrofraca.domain.usecase.favourite.repository.FavouritesRepository
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam

class FavouritesRepositoryImpl(
    private val setFavouriteApi: WriteDataSourceWithFilter<SetStageAsFavoriteParam, Boolean>,
    private val favouritesListApi: ReadOnlyDataSource<String>
) : FavouritesRepository {

    override fun setFavouriteStage(param: SetStageAsFavoriteParam) : Boolean {
        return setFavouriteApi.save(param)
    }

    override fun getFavouriteStagesByUserId(userId: String): List<String> {
        return favouritesListApi.getAll()
    }
}