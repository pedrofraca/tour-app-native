package io.github.pedrofraca.test.ranking

import io.github.pedrofraca.domain.usecase.ranking.GetTopRankedStagesUseCaseImpl
import io.github.pedrofraca.domain.usecase.ranking.repository.RankeableStageRepository
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test

class GetTopRankedStagesUseCaseTest {
    private val repository = mockk<RankeableStageRepository>(relaxed = true)

    @Test
    fun `invoking GetTopRankedStagesUseCase calls RankeableRepository to retrieve top ranked Stages`() {
        val getTopRankedStagesUseCase = GetTopRankedStagesUseCaseImpl(repository)

        getTopRankedStagesUseCase()

        verify(exactly = 1) { repository.rankeableStages }
    }
}