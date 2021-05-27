package fr.sbelhadj.animeapp.presentation.api

data class AnimeDetailResponse (
        val id : Int,
        val episodes : List<Episode>
)


data class Episode (
        val episode_id : Int,
        val title : String
)