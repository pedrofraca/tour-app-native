package io.github.pedrofraca.data.datasource.stage

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSource
import io.github.pedrofraca.domain.model.StageModel
import io.github.pedrofraca.domain.usecase.stage.repository.StageRepository

/**
 * Repository class to manage stages. Which basically uses two data sources.
 * One to retrieve the Stages and the other one to persists them.
 */

open class StagesRepositoryImpl(private val readDataSource: ReadOnlyDataSource<StageModel>,
                                private val persistenceDataSource: WriteDataSource<StageModel>) : StageRepository {

    override fun refresh(): List<StageModel> {
        val stages = readDataSource.getAll()
        stages.forEach {
            persistenceDataSource.save(it)
        }
        return stages
    }

    override val stages: List<StageModel>
        get() = persistenceDataSource.getAll()
}