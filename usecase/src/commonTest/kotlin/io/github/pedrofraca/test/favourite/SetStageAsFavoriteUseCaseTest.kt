package io.github.pedrofraca.test.favourite

import io.github.pedrofraca.domain.usecase.favourite.SetStageAsFavoriteUseCaseImpl
import io.github.pedrofraca.domain.usecase.favourite.repository.FavouritesRepository
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test

class SetStageAsFavoriteUseCaseTest {

    private val repository = mockk<FavouritesRepository>(relaxed = true)

    @Test
    fun `invoking SetStageAsFavorite must call FavouritesRepository`() {
        val param = SetStageAsFavoriteParam("id_0", true)

        val setStageAsFavoriteUseCase = SetStageAsFavoriteUseCaseImpl(repository)
        setStageAsFavoriteUseCase(param)

        verify(exactly = 1) { repository.setFavouriteStage(param) }
    }
}