package io.github.pedrofraca.test.stage

import io.github.pedrofraca.data.datasource.stage.StageRepository
import io.github.pedrofraca.domain.usecase.stage.GetStagesUseCaseImpl
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test

class GetStagesUseCaseTest {
    private val repository = mockk<StageRepository>(relaxed = true)

    @Test
    fun `invoking GetStagesUseCase calls StageRepository to retrieve Stages`() {
        val getStagesUseCase = GetStagesUseCaseImpl(repository)

        getStagesUseCase()

        verify(exactly = 1) { repository.stages }
    }
}