package io.github.pedrofraca.data.datasource.stage

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.data.datasource.WriteDataSource
import io.github.pedrofraca.domain.model.Stage

expect class StagesRepositoryFactory() {
    fun build(apiDataSource: ReadOnlyDataSource<Stage>,
              databaseDataSource: WriteDataSource<Stage>) : StagesRepositoryImpl
}