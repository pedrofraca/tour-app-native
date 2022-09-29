package io.github.pedrofraca.data.datasource.stage

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSource
import io.github.pedrofraca.domain.model.Stage
import kotlin.native.concurrent.freeze

actual class StagesRepositoryFactory actual constructor() {
    actual fun build(
        apiDataSource: ReadOnlyDataSource<Stage>,
        databaseDataSource: WriteDataSource<Stage>
    ): StagesRepositoryImpl {
        val repoImpl = StagesRepositoryImpl(apiDataSource, databaseDataSource)
        repoImpl.freeze()
        return repoImpl
    }
}