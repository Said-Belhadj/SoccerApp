package fr.sbelhadj.animeapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.sbelhadj.soccerapp.R
import fr.sbelhadj.animeapp.presentation.Singletons
import fr.sbelhadj.animeapp.presentation.api.AnimeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView;
    private val adapter =
        CompetitionAdapter(
            listOf(),
            ::onClickedCompetition
        )

    private val  layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_competition_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.competition_recyclerview)

        recyclerView.apply {
            layoutManager = this@AnimeListFragment.layoutManager
            adapter = this@AnimeListFragment.adapter
        }


        Singletons.animeApi.getAnimeList().enqueue(object : Callback<AnimeResponse>{
            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<AnimeResponse>,
                response: Response<AnimeResponse>
            ) {
                if(response.isSuccessful && response.body()!= null){
                    val AnimeResponse = response.body()!!
                    adapter.updateList(AnimeResponse.top)
                }
            }

        })

    }

    private fun onClickedCompetition(anime: Anime) {
        findNavController().navigate(R.id.navigateToAnimeDetailFragment)
    }
}

