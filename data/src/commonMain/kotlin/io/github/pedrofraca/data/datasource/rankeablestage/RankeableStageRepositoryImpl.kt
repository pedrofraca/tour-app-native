package io.github.pedrofraca.data.datasource.rankeablestage

import io.github.pedrofraca.data.datasource.ReadOnlyDataSource
import io.github.pedrofraca.domain.model.RankeableStage
import io.github.pedrofraca.domain.usecase.ranking.repository.RankeableStageRepository

class RankeableStageRepositoryImpl (private val dataSource : ReadOnlyDataSource<RankeableStage>) :
    RankeableStageRepository {

    private var elements : List<RankeableStage> = emptyList()

    override val rankeableStages: List<RankeableStage> get()  {
        if(elements.isEmpty()) {
            elements = refresh()
        }
        return elements
    }

    override fun refresh(): List<RankeableStage> {
        return dataSource.getAll()
    }
}