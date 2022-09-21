package io.github.pedrofraca.test

import io.github.pedrofraca.domain.model.RateableStage
import kotlin.test.Test
import kotlin.test.assertFailsWith

class TestFavStagePolicy {

    @Test
    internal fun `user can mark a stage as fav`() {
         RateableStage(1, "USERNAME", false)
    }

    @Test
    internal fun `user can only mark fav once`() {
        assertFailsWith(IllegalStateException::class) {
            RateableStage(2,"USERNAME", true)
        }
    }

}