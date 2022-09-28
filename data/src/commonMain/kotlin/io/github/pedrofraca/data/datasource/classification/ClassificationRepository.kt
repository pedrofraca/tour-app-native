package io.github.pedrofraca.data.datasource.classification

import io.github.pedrofraca.domain.model.StageClassification

interface ClassificationRepository {

    /**
     * Triggers a network update for the classification for the given stage. Stores the result
     * in the writable data source.
     */
    fun refreshForStage(stage : String) : StageClassification

    /**
     * Reads the stored status for the classifications.
     */
    fun getClassificationForStage(stage: String) : StageClassification
}