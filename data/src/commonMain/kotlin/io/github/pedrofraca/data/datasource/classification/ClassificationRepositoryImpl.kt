package io.github.pedrofraca.data.datasource.classification

import io.github.pedrofraca.data.datasource.ReadOnlyDataSourceWithFilter
import io.github.pedrofraca.data.datasource.WriteDataSourceWithFilter
import io.github.pedrofraca.domain.model.StageClassification

class ClassificationRepositoryImpl(private val api: ReadOnlyDataSourceWithFilter<StageClassification, String>,
                                   private val db: WriteDataSourceWithFilter<StageClassification, String>) : ClassificationRepository {

    override fun refreshForStage(stage: String) : StageClassification {
        val classification = api.get(stage)
        db.save(classification, stage)
        return classification
    }

    override fun getClassificationForStage(stage: String): StageClassification {
        return db.get(stage)
    }

}
