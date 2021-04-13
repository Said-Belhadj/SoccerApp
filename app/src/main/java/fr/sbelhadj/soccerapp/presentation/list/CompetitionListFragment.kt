package fr.sbelhadj.soccerapp.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.sbelhadj.soccerapp.R
import fr.sbelhadj.soccerapp.presentation.api.FootballApi
import fr.sbelhadj.soccerapp.presentation.api.CompetitionResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CompetitionListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView;
    private val adapter = CompetitionAdapter(listOf())
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
            layoutManager = this@CompetitionListFragment.layoutManager
            adapter = this@CompetitionListFragment.adapter
        }


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.football-data.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val footballApi = retrofit.create(FootballApi::class.java)

        footballApi.getCompetitionList().enqueue(object : Callback<CompetitionResponse>{
            override fun onFailure(call: Call<CompetitionResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<CompetitionResponse>,
                response: Response<CompetitionResponse>
            ) {
                if(response.isSuccessful && response.body()!= null){
                    val competitionResponse = response.body()!!
                    adapter.updateList(competitionResponse.competitions)
                }
            }

        })

    }
}

