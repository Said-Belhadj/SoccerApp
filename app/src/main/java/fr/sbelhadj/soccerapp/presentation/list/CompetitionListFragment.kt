package fr.sbelhadj.soccerapp.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.sbelhadj.soccerapp.R

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

        val competitionList = arrayListOf<String>().apply {
            add("Ligue 2")
            add("Ligue 1")
            add("Liga Satanden")
            add("Premier League")
        }

        adapter.updateList(competitionList)
    }
}