package fr.sbelhadj.soccerapp.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import fr.sbelhadj.soccerapp.R
import fr.sbelhadj.soccerapp.presentation.Singletons
import fr.sbelhadj.soccerapp.presentation.api.AnimeDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AnimeDetailFragment : Fragment() {

    private lateinit var textViewName : TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_competition_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.match_id)
        callApi()
    }

    private fun callApi(){
        Singletons.animeApi.getCompetitionDetail("2021").enqueue(object : Callback<AnimeDetailResponse>{
            override fun onFailure(call: Call<AnimeDetailResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<AnimeDetailResponse>, response: Response<AnimeDetailResponse>) {
                if(response.isSuccessful && response.body()!= null){
                    textViewName.text = response.body()!!.id.toString()

                }
            }

        })
    }
}