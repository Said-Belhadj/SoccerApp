package fr.sbelhadj.animeapp.presentation

import fr.sbelhadj.animeapp.presentation.api.AnimeApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons {
    companion object {
        val animeApi : AnimeApi = Retrofit.Builder()
                .baseUrl("https://api.jikan.moe/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AnimeApi::class.java)
    }
}