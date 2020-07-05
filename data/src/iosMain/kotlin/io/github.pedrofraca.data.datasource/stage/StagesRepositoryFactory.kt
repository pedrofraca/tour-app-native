package io.github.pedrofraca.data.datasource.stage

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSource
import io.github.pedrofraca.domain.model.StageModel
import kotlin.native.concurrent.freeze

actual class StagesRepositoryFactory actual constructor() {
    actual fun build(
        apiDataSource: ReadOnlyDataSource<StageModel>,
        databaseDataSource: WriteDataSource<StageModel>
    ): StagesRepositoryImpl {
        val repoImpl = StagesRepositoryImpl(apiDataSource, databaseDataSource)
        repoImpl.freeze()
        return repoImpl
    }
}