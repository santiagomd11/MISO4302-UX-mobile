package com.example.friendlygym.ui.editar_calentamiento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.friendlygym.R
import com.example.friendlygym.ui.calentamiento.CalentamientoFragment
import com.google.android.material.snackbar.Snackbar

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditarCalentamientoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditarCalentamientoFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editar_calentamiento, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.buttonGuardarCalentamiento).setOnClickListener {
            var snackbar = Snackbar.make(requireView(), "Tiempo de calentamiento guardado", Snackbar.LENGTH_SHORT)
            snackbar.setBackgroundTint(resources.getColor(R.color.green_100))
            snackbar.setTextColor(resources.getColor(R.color.black))
            snackbar.show()

            val navController = findNavController()

            val navListener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
                val currentDestinationId = destination.id
                if (currentDestinationId == R.id.nav_calentamiento) {
                    var snackbar = Snackbar.make(requireView(), "Tiempo de calentamiento guardado", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(resources.getColor(R.color.green_100))
                    snackbar.setTextColor(resources.getColor(R.color.black))
                    snackbar.show()
                    CalentamientoFragment.SnackbarManager.snackbarShown = true
                }
            }
            navController.addOnDestinationChangedListener(navListener)
            view?.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
                override fun onViewDetachedFromWindow(p0: View) {
                    navController.removeOnDestinationChangedListener(navListener)
                }

                override fun onViewAttachedToWindow(p0: View) {}
            })

            navController.navigate(R.id.nav_calentamiento)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditarCalentamientoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditarCalentamientoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}