package io.github.pedrofraca.data.datasource.stage

import io.github.pedrofraca.domain.model.StageModel

interface StageRepository {
    /**
     * Gets the current stages stored in the cache. Empty is no stages are stored.
     */
    val stages: List<StageModel>

    /**
     * Triggers an update and stores te result in the write data source.
     */
    fun refresh() : List<StageModel>
}