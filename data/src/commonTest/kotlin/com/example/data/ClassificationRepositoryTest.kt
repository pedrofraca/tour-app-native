package com.example.data

import io.github.pedrofraca.data.datasource.*
import io.github.pedrofraca.data.datasource.classification.ClassificationRepositoryImpl
import io.github.pedrofraca.domain.model.StageClassificationModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class ClassificationRepositoryTest {
    private val api = mockk<ReadOnlyDataSourceWithFilter<StageClassificationModel, String>>(relaxed = true)
    private val db = mockk<WriteDataSourceWithFilter<StageClassificationModel, String>>(relaxed = true)
    private val repo = ClassificationRepositoryImpl(api, db)

    @Test
    fun `test we persists classifications`() {
        every { api.get("1") } returns StageClassificationModel(emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), stage = "1")

        repo.refreshForStage("1")

        verify { api.get("1") }
        verify { db.save(any()) }
    }
}