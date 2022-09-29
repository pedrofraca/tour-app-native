package io.github.pedrofraca.test

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSource
import io.github.pedrofraca.data.datasource.stage.StagesRepositoryImpl
import io.github.pedrofraca.domain.model.Stage
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test

class StageRepositoryTest {

    private val db = mockk<WriteDataSource<Stage>>(relaxed = true)
    private val api = mockk<ReadOnlyDataSource<Stage>>(relaxed = true)
    private val repo = StagesRepositoryImpl(api, db)

    @Test
    fun `test empty response doesn't save anything`() {
        every { api.getAll() } returns emptyList()

        repo.refresh()

        verify { api.getAll() }
        verify(exactly = 0) { db.save(any()) }
    }

    @Test
    fun `test non empty response saves items`() {
        every { api.getAll() } returns listOf(Stage("This is the first stage",
            stage = 1,
            profileImgUrl = ""))

        repo.refresh()

        verify { api.getAll()}
        verify(exactly = 1) { db.save(any()) }
    }
}