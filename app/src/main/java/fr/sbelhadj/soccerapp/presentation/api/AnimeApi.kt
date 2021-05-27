package fr.sbelhadj.soccerapp.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface AnimeApi {
    @GET("top/anime")
    fun getAnimeList():  Call<AnimeResponse>

    @GET("anime/{id}/episodes")
    fun getCompetitionDetail(@Path("id") id: String): Call<AnimeDetailResponse>


}