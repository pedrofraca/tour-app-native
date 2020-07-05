package io.github.pedrofraca.data.datasource.stage

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSource
import io.github.pedrofraca.domain.model.StageModel

/**
 * Repository class to manage stages. Which basically uses two data sources.
 * One to retrieve the Stages and the other one to persists them.
 */

open class StagesRepositoryImpl(private val apiDataSource: ReadOnlyDataSource<StageModel>,
                                private val databaseDataSource: WriteDataSource<StageModel>) : StageRepository {

    override fun refresh(): List<StageModel> {
        val stages = apiDataSource.getAll()
        stages.forEach {
            databaseDataSource.save(it)
        }
        return stages
    }

    override val stages: List<StageModel>
        get() = databaseDataSource.getAll()
}