package io.github.pedrofraca.test

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.rankeablestage.RankeableStageRepositoryImpl
import io.github.pedrofraca.domain.model.RankeableStage
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test

class RankeableStageRepository {
    private val api = mockk<ReadOnlyDataSource<RankeableStage>>(relaxed = true)

    @Test
    internal fun `if no rankeable stages in memory we call to the datasource`() {
        val rankeableRepository = RankeableStageRepositoryImpl(api)
        rankeableRepository.rankeableStages
        verify { api.getAll() }
    }

    @Test
    internal fun `if rankeable stages in memory we call to the datasource`() {
        val rankeableRepository = RankeableStageRepositoryImpl(api)
        rankeableRepository.rankeableStages
        rankeableRepository.rankeableStages
        verify(exactly = 1) { api.getAll() }
    }
}