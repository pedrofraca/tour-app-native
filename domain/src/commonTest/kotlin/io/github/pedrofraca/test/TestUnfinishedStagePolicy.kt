package io.github.pedrofraca.test

import io.github.pedrofraca.domain.mapper.StageToRatetableStageMapperImpl
import io.github.pedrofraca.domain.model.StageModel
import kotlin.test.*

class TestUnfinishedStagePolicy {

    @Test
    fun `unfinished stage must NOT be allowed`() {
        val stageModel = StageModel(name = "SAMPLE_STAGE", stage = 0)
        val mapper = StageToRatetableStageMapperImpl()
        assertFailsWith(IllegalStateException::class) {
            mapper(stageModel)
        }
    }

    @Test
    fun `finished stage must be allowed`() {
        val stageModel = StageModel(name = "SAMPLE_STAGE", stage = 0, winner = "SAMPLE_WINNER")
        val mapper = StageToRatetableStageMapperImpl()
        mapper(stageModel)
    }

}