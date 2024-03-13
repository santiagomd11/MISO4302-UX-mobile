package com.example.friendlygym.ui.routines
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.friendlygym.R
import com.example.friendlygym.models.Routine
import com.example.friendlygym.ui.adapters.RoutinesAdapter
import com.example.friendlygym.ui.activities.AddRoutineActivity

class RoutinesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val routineList = mutableListOf<Routine>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_routines, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_routines)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RoutinesAdapter(routineList)

        view.findViewById<FloatingActionButton>(R.id.fab_add_routine).setOnClickListener {
            startActivityForResult(Intent(activity, AddRoutineActivity::class.java), REQUEST_ADD_ROUTINE)
        }

        updateUI()

        return view
    }

    private fun updateUI() {
        if (routineList.isEmpty()) {
            recyclerView.visibility = View.GONE
            view?.findViewById<View>(R.id.empty_view)?.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            view?.findViewById<View>(R.id.empty_view)?.visibility = View.GONE
        }
    }

    companion object {
        private const val REQUEST_ADD_ROUTINE = 1
    }
}
