package iteoakademia.patryk.myapplication.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iteoakademia.patryk.myapplication.R
import iteoakademia.patryk.myapplication.viewmodel.FragmentPasswordViewModel

class FragmentPassword : Fragment() {

    companion object {
        fun newInstance() = FragmentPassword()
    }

    private lateinit var viewModel: FragmentPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentPasswordViewModel::class.java)
        // TODO: Use the ViewModel
    }

}