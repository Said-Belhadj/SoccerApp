package fr.sbelhadj.soccerapp.presentation.api

import fr.sbelhadj.soccerapp.presentation.list.Competition

data class CompetitionResponse (
    val count : Int,
    val competitions : List<Competition>
)