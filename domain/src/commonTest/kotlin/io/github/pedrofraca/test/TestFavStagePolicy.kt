package io.github.pedrofraca.test

import io.github.pedrofraca.domain.model.RatetableStage
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class TestFavStagePolicy {

    @Test
    internal fun `user can mark a stage as fav`() {
        val stage = RatetableStage("NAME")
        assertTrue { stage.fav() }
    }

    @Test
    internal fun `user can only mark fav once`() {
        val stage = RatetableStage("NAME")
        stage.fav()

        assertFailsWith(IllegalStateException::class) {
            stage.fav()
        }
    }

}