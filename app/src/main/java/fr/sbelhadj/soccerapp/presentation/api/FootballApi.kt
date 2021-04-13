package fr.sbelhadj.soccerapp.presentation.api

import retrofit2.Call
import retrofit2.http.GET


interface FootballApi {
    @GET("competitions")
    fun getCompetitionList():  Call<CompetitionResponse>
}