package io.github.pedrofraca.domain.model

data class StageModel(
        val name: String,
        val winner: String? = null,
        val leader: String? = null,
        val images: List<String>? = null,
        val description: String? = null,
        val km: String? = null,
        val imgUrl: String? = null,
        val date: String? = null,
        val stage: String,
        val averageSpeed: String? = null,
        val startFinish: String? = null) {

    fun completed(): Boolean {
        return winner?.isNotEmpty()?:false
    }
}