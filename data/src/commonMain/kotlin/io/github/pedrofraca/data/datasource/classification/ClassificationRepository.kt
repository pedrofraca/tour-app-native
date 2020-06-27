package io.github.pedrofraca.data.datasource.classification

import io.github.pedrofraca.domain.model.StageClassificationModel

interface ClassificationRepository {

    /**
     * Triggers a network update for the classification for the given stage. Stores the result
     * in the writable data source.
     */
    fun refreshForStage(stage : String) : StageClassificationModel

    /**
     * Reads the stored status for the classifications.
     */
    fun getClassificationForStage(stage: String) : StageClassificationModel
}