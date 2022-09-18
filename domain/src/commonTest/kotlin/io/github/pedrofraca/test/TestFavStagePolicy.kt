package io.github.pedrofraca.test

import io.github.pedrofraca.domain.model.RateableStage
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class TestFavStagePolicy {

    @Test
    internal fun `user can mark a stage as fav`() {
        val stage = RateableStage(1)
        assertTrue { stage.fav() }
    }

    @Test
    internal fun `user can only mark fav once`() {
        val stage = RateableStage(2)
        stage.fav()

        assertFailsWith(IllegalStateException::class) {
            stage.fav()
        }
    }

}