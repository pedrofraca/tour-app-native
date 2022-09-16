package io.github.pedrofraca.domain.model

data class StageModel(
        val name: String,
        val stage: Int,
        val winner: String? = null,
        val leader: String? = null,
        val images: List<String>? = null,
        val description: String? = null,
        val km: String? = null,
        val imgUrl: String? = null,
        val profileImgUrl: String? = null,
        val date: String? = null,
        val averageSpeed: String? = null,
        val startFinish: String? = null) {

    fun completed(): Boolean {
        return winner?.isNotEmpty()?:false
    }
}