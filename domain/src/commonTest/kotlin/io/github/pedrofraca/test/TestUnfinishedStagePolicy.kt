package io.github.pedrofraca.test

import io.github.pedrofraca.domain.mapper.StageToRateableStageMapperImpl
import io.github.pedrofraca.domain.model.Stage
import kotlin.test.*

class TestUnfinishedStagePolicy {

    @Test
    fun `unfinished stage must NOT be allowed`() {
        val stage = Stage(name = "SAMPLE_STAGE", stage = 0)
        val mapper = StageToRateableStageMapperImpl()
        assertFailsWith(IllegalStateException::class) {
            mapper(stage, "username", false)
        }
    }

    @Test
    fun `finished stage must be allowed`() {
        val stage = Stage(name = "SAMPLE_STAGE", stage = 0, winner = "SAMPLE_WINNER")
        val mapper = StageToRateableStageMapperImpl()
        mapper(stage, "username", false)
    }

}