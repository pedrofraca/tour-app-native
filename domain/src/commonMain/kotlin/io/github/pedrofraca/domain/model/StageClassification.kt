package io.github.pedrofraca.domain.model


data class StageClassification(
        var mountain: List<Classification>,
        var team: List<Classification>,
        var general: List<Classification>,
        var regularity: List<Classification>,
        var stageClassification: List<Classification>,
        var stage: String)