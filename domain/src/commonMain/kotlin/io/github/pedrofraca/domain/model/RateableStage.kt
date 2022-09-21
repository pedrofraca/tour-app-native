package io.github.pedrofraca.domain.model

class RateableStage(id: Int, username: String?, fav: Boolean) {
    init {
        if (fav) {
            throw IllegalStateException("Stage already rated")
        }
    }
}
