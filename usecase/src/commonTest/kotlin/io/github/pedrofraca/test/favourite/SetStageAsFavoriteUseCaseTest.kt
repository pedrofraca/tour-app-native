package io.github.pedrofraca.test.favourite

import io.github.pedrofraca.domain.usecase.favourite.SetStageAsFavoriteUseCaseImpl
import io.github.pedrofraca.domain.usecase.favourite.repository.FavouritesRepository
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SetStageAsFavoriteUseCaseTest {

    @Test
    fun `invoking SetStageAsFavorite for neutral Stage must return True`() {
        val acceptingRepository = createFavouritesRepository(acceptFavourite = true)
        val param = SetStageAsFavoriteParam(username = "username", stageId = "id_0", favouriteState = true)
        val setStageAsFavoriteUseCase = SetStageAsFavoriteUseCaseImpl(acceptingRepository)

        val result = setStageAsFavoriteUseCase(param)

        assertTrue { result }
    }

    @Test
    fun `invoking SetStageAsFavorite for already favourited Stage must return False`() {
        val failingRepository = createFavouritesRepository(acceptFavourite = false)
        val param = SetStageAsFavoriteParam(username = "username", stageId = "id_0", favouriteState = true)
        val setStageAsFavoriteUseCase = SetStageAsFavoriteUseCaseImpl(failingRepository)

        val result = setStageAsFavoriteUseCase(param)

        assertFalse { result }
    }

    /**
     * Creates implementation of FavouritesRepository,
     * which returns @param acceptFavourite as result of #setFavouriteStage()
     */
    private fun createFavouritesRepository(acceptFavourite: Boolean) = object : FavouritesRepository {
        override fun setFavouriteStage(param: SetStageAsFavoriteParam): Boolean {
            return acceptFavourite
        }

        override fun getFavouriteStagesByUsername(username: String): List<String> {
            return emptyList()
        }
    }
}