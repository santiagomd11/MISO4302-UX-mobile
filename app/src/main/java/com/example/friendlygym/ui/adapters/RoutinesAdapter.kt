package com.example.friendlygym.ui.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friendlygym.R
import com.example.friendlygym.models.Routine

class RoutinesAdapter(private val routines: MutableList<com.example.friendlygym.models.Routine>) : RecyclerView.Adapter<RoutinesAdapter.RoutineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_routine, parent, false)
        return RoutineViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        val routine = routines[position]
        holder.bind(routine)
    }

    override fun getItemCount() = routines.size

    class RoutineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(routine: Routine) {
            itemView.findViewById<TextView>(R.id.RoutineName).text = routine.name
            // Set up click listeners for edit and delete buttons
            itemView.findViewById<ImageButton>(R.id.btnEditRoutine).setOnClickListener {
                // Handle edit button click
            }
            itemView.findViewById<ImageButton>(R.id.btnDeleteRoutine).setOnClickListener {
                // Handle delete button click
            }
        }
    }
}
