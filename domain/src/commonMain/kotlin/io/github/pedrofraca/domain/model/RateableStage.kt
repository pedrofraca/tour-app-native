package io.github.pedrofraca.domain.model

data class RateableStage(
    val id: Int,
    private var fav : Boolean = false
) {
    fun fav() : Boolean {
        if(fav){
            throw IllegalStateException("Stage is already favourited.")
        }
        fav = true
        return true
    }
}
