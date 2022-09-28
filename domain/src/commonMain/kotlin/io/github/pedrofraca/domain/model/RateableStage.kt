package io.github.pedrofraca.domain.model

class RateableStage(stage: Stage, username: String?, fav: Boolean) {
    init {
        if (stage.completed().not()) {
            throw IllegalStateException("Stage is not completed yet, therefore it can not be rated.")
        }
        if (fav) {
            throw IllegalStateException("Stage already rated")
        }
    }
}
