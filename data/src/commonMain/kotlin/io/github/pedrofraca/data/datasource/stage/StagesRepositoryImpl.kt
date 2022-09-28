package io.github.pedrofraca.data.datasource.stage

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSource
import io.github.pedrofraca.domain.model.Stage
import io.github.pedrofraca.domain.usecase.stage.repository.StageRepository

/**
 * Repository class to manage stages. Which basically uses two data sources.
 * One to retrieve the Stages and the other one to persists them.
 */

open class StagesRepositoryImpl(private val readDataSource: ReadOnlyDataSource<Stage>,
                                private val persistenceDataSource: WriteDataSource<Stage>) : StageRepository {

    override fun refresh(): List<Stage> {
        val stages = readDataSource.getAll()
        stages.forEach {
            persistenceDataSource.save(it)
        }
        return stages
    }

    override fun getStageById(stageId: Int): Stage? {
        return readDataSource.getAll().firstOrNull { it.stage == stageId }
    }

    override val stages: List<Stage>
        get() = persistenceDataSource.getAll()
}