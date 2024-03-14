package com.example.friendlygym.ui.calentamiento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.friendlygym.R
import com.google.android.material.snackbar.Snackbar

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalentamientoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalentamientoFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    object SnackbarManager {
        @JvmStatic
        var snackbarShown = false
    }

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
        return inflater.inflate(R.layout.fragment_calentamiento, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.buttonEditarCalentamiento).setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.editar_calentamiento)
        }
    }

    override fun onResume() {
        super.onResume()

        if (!SnackbarManager.snackbarShown) {
            val snackbar = Snackbar.make(requireView(), "¡Aún no tiene un tiempo programado!", Snackbar.LENGTH_SHORT)
            snackbar.setBackgroundTint(resources.getColor(R.color.orange_200))
            snackbar.setTextColor(resources.getColor(R.color.black))
            snackbar.show()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Calentamiento.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalentamientoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}