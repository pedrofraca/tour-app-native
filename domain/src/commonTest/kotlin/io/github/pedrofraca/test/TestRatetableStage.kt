package io.github.pedrofraca.test

import io.github.pedrofraca.domain.model.RateableStage
import io.github.pedrofraca.domain.model.Stage
import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestRatetableStage {
    private val stage = mockk<Stage>(relaxed = true).apply {
        every { completed() } returns true
    }

    @Test
    internal fun `user can NOT mark an unfinished stage as fav`() {
        every { stage.completed() } returns false
        assertFailsWith(IllegalStateException::class) {
            RateableStage(stage, "USERNAME", false)
        }
    }

    @Test
    internal fun `user can mark a stage as fav`() {
        RateableStage(stage, "USERNAME", false)
    }

    @Test
    internal fun `user can only mark fav once`() {
        assertFailsWith(IllegalStateException::class) {
            RateableStage(stage, "USERNAME", true)
        }
    }
}