package io.github.pedrofraca.test

import io.github.pedrofraca.data.datasource.*
import io.github.pedrofraca.data.datasource.classification.ClassificationRepositoryImpl
import io.github.pedrofraca.domain.model.StageClassification
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test

class ClassificationRepositoryTest {
    private val api = mockk<ReadOnlyDataSourceWithFilter<StageClassification, String>>(relaxed = true)
    private val db = mockk<WriteDataSourceWithFilter<StageClassification, String>>(relaxed = true)
    private val repo = ClassificationRepositoryImpl(api, db)

    @Test
    fun `test we persists classifications`() {
        every { api.get("1") } returns StageClassification(emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), stage = "1")

        repo.refreshForStage("1")

        verify { api.get("1") }
        verify { db.save(any(), "1") }
    }
}