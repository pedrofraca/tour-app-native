package io.github.pedrofraca.data.datasource.rankeablestage

import io.github.pedrofraca.domain.model.RankeableStage

//TODO Consider to remove this type of repository to an interface with generics
interface RankeableStageRepository {
    /**
     * Gets the current ranked stages
     */
    val rankeableStages: List<RankeableStage>

    /**
     * Triggers an update and gets an updated version of the Ranked Stages.
     */
    fun refresh() : List<RankeableStage>
}