package io.github.pedrofraca.test

import io.github.pedrofraca.domain.model.StageModel
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestStage {
    @Test
    fun testStageIsCompleted() {
        assertTrue(StageModel(name = "io.github.pedrofraca.test.TestStage", winner = "Pedro", stage = 1, profileImgUrl = "").completed(),
            "Stage must be completed if the name of the winner is not null")
    }

    @Test
    fun testStageIsNotCompleted() {
        assertFalse(StageModel(name = "io.github.pedrofraca.test.TestStage", stage = 1, profileImgUrl = "").completed(),
            "Stage mustn't be completed if the name of the winner is not null")
    }
}