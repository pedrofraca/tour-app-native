package io.github.pedrofraca.domain.usecase.stage.repository

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
}