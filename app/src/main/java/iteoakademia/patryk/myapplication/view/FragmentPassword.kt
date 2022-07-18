package iteoakademia.patryk.myapplication.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.google.android.material.slider.Slider
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

        val btnGeneratePassword = getView()?.findViewById<Button>(R.id.btnGeneratePassword)
        val tvShowPassword = getView()?.findViewById<TextView>(R.id.tvShowPassword)
        val sliderPasswordLength = getView()?.findViewById<Slider>(R.id.sliderPasswordLength)
        val checkBoxSpecialCharacters = getView()?.findViewById<CheckBox>(R.id.checkboxSpecialCharacters)
        val checkBoxNumbers = getView()?.findViewById<CheckBox>(R.id.checkboxNumbers)

        btnGeneratePassword?.setOnClickListener {
            viewModel.generatePassword(sliderPasswordLength?.value?.toInt(), checkBoxSpecialCharacters, checkBoxNumbers)
            tvShowPassword?.text = viewModel.password
        }
    }

}