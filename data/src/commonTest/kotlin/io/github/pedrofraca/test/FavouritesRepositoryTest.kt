package io.github.pedrofraca.test

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSourceWithFilter
import io.github.pedrofraca.data.datasource.favourites.FavouritesRepositoryImpl
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test
import kotlin.test.assertTrue

class FavouritesRepositoryTest {
    private val setFavouriteApi = mockk<WriteDataSourceWithFilter<SetStageAsFavoriteParam, Boolean>>()
    private val favouritesListApi = mockk<ReadOnlyDataSource<String>>()


    @Test
    fun `setting favourited stage must call setFavouriteApi`() {
        val favouritesRepository = FavouritesRepositoryImpl(setFavouriteApi, favouritesListApi)

        val param = SetStageAsFavoriteParam("username", "id_0", true)
        favouritesRepository.setFavouriteStage(param)

        verify { setFavouriteApi.save(param) }
    }

    @Test
    fun `getFavouriteStagesByUserId must invoke api to retrieve Stages`() {
        val favouritesRepository = FavouritesRepositoryImpl(setFavouriteApi, favouritesListApi)
        val stagesId = listOf("id_0", "id_1", "id_2")
        every { favouritesListApi.getAll() } returns stagesId

        val result = favouritesRepository.getFavouriteStagesByUserId("userId_0")

        assertTrue { result.containsAll(stagesId) }
    }
}