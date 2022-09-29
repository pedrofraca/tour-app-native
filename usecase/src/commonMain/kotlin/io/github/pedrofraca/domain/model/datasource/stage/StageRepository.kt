package io.github.pedrofraca.data.datasource.stage

import io.github.pedrofraca.domain.model.Stage

interface StageRepository {
    /**
     * Gets the current stages stored in the cache. Empty is no stages are stored.
     */
    val stages: List<Stage>

    /**
     * Triggers an update and gets an updated version of the Stages.
     */
    fun refresh() : List<Stage>

    /**
     * Gets a stage by id
     */
    fun getStageById(stageId: Int) : Stage?
}