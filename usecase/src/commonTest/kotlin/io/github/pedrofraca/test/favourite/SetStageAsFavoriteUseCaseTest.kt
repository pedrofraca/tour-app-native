package io.github.pedrofraca.test.favourite

import io.github.pedrofraca.domain.usecase.favourite.SetStageAsFavoriteUseCaseImpl
import io.github.pedrofraca.domain.usecase.favourite.repository.FavouritesRepository
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam
import io.github.pedrofraca.domain.usecase.ranking.repository.RankeableStageRepository
import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SetStageAsFavoriteUseCaseTest {

    private val repository = mockk<FavouritesRepository>(relaxed = true)


    @Test
    fun `invoking SetStageAsFavorite for neutral Stage must return True`() {
        val param = SetStageAsFavoriteParam(username = "username", stageId = 0, favouriteState = false)

        every { repository.getFavouriteStagesByUsername(param.username) } returns listOf(param)
        every { repository.setFavouriteStage(any()) } returns true


        val setStageAsFavoriteUseCase = SetStageAsFavoriteUseCaseImpl(repository)

        val result = setStageAsFavoriteUseCase(param)

        assertTrue { result }
    }

    @Test
    fun `invoking SetStageAsFavorite for already favourited Stage must return False`() {
        val param = SetStageAsFavoriteParam(username = "username", stageId = 0, favouriteState = true)

        every { repository.getFavouriteStagesByUsername(param.username) } returns listOf(param)

        val setStageAsFavoriteUseCase = SetStageAsFavoriteUseCaseImpl(repository)

        assertFailsWith(IllegalStateException::class) {
            setStageAsFavoriteUseCase(param)
        }
    }
}