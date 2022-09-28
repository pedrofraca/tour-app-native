package io.github.pedrofraca.test.favourite

import io.github.pedrofraca.domain.model.Stage
import io.github.pedrofraca.domain.usecase.favourite.SetStageAsFavoriteUseCaseImpl
import io.github.pedrofraca.domain.usecase.favourite.repository.FavouritesRepository
import io.github.pedrofraca.domain.usecase.favourite.repository.SetStageAsFavoriteParam
import io.github.pedrofraca.domain.usecase.stage.repository.StageRepository
import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class SetStageAsFavoriteUseCaseTest {

    private val repository = mockk<FavouritesRepository>(relaxed = true)
    private val stageRepository = mockk<StageRepository>(relaxed = true)


    @Test
    fun `invoking SetStageAsFavorite for neutral Stage must return True`() {
        val param = SetStageAsFavoriteParam(username = "username", stageId = 0, favouriteState = false)
        val completedStage = mockk<Stage>(relaxed = true)

        every { repository.getStageByUsername(param.stageId, param.username) } returns param
        every { repository.setFavouriteStage(param) } returns true
        every { completedStage.completed() } returns true
        every { stageRepository.getStageById(param.stageId) } returns completedStage


        val setStageAsFavoriteUseCase = SetStageAsFavoriteUseCaseImpl(repository, stageRepository)

        val result = setStageAsFavoriteUseCase(param)

        assertTrue { result }
    }

    @Test
    fun `invoking SetStageAsFavorite for already favourited Stage must return False`() {
        val param = SetStageAsFavoriteParam(username = "username", stageId = 0, favouriteState = true)

        every { repository.getFavouriteStagesByUsername(param.username) } returns listOf(param)

        val setStageAsFavoriteUseCase = SetStageAsFavoriteUseCaseImpl(repository, stageRepository)

        assertFailsWith(IllegalStateException::class) {
            setStageAsFavoriteUseCase(param)
        }
    }
}