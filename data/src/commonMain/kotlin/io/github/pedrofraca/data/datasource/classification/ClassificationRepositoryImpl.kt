package io.github.pedrofraca.data.datasource.classification

import io.github.pedrofraca.data.datasource.ReadOnlyDataSourceWithFilter
import io.github.pedrofraca.data.datasource.WriteDataSourceWithFilter
import io.github.pedrofraca.domain.model.StageClassificationModel

class ClassificationRepositoryImpl(private val api: ReadOnlyDataSourceWithFilter<StageClassificationModel, String>,
                                   private val db: WriteDataSourceWithFilter<StageClassificationModel, String>) : ClassificationRepository {

    override fun refreshForStage(stage: String) : StageClassificationModel {
        val classification = api.get(stage)
        db.save(classification)
        return classification
    }

    override fun getClassificationForStage(stage: String): StageClassificationModel {
        return db.get(stage)
    }

}
