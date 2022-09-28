package io.github.pedrofraca.domain.model

class RateableStage(stage: Stage?, username: String?, fav: Boolean) {
    init {
        stage?.let {
            if (stage.completed().not()) {
                throw IllegalStateException("Stage is not completed yet, therefore it can not be rated.")
            }
            if (fav) {
                throw IllegalStateException("Stage already rated")
            }
        } ?: run {
            throw IllegalStateException( "Stage doesn't exist")
        }
    }
}
