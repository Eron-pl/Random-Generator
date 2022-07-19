package iteoakademia.patryk.myapplication.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
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

        val animation = AnimationUtils.loadAnimation(this.context, R.anim.fade_in_and_translate)

        val btnGeneratePassword = getView()?.findViewById<Button>(R.id.btnGeneratePassword)
        val tvShowPassword = getView()?.findViewById<TextView>(R.id.tvShowPassword)
        val sliderPasswordLength = getView()?.findViewById<Slider>(R.id.sliderPasswordLength)
        val checkBoxSpecialCharacters = getView()?.findViewById<CheckBox>(R.id.checkboxSpecialCharacters)
        val checkBoxNumbers = getView()?.findViewById<CheckBox>(R.id.checkboxNumbers)
        val llSpecialCharacters = getView()?.findViewById<LinearLayout>(R.id.llSpecialCharacters)
        val llNumbers = getView()?.findViewById<LinearLayout>(R.id.llNumbers)
        val llSliderPasswordLength = getView()?.findViewById<LinearLayout>(R.id.llSliderPasswordLength)

        btnGeneratePassword?.startAnimation(animation)
        tvShowPassword?.startAnimation(animation)
        llSpecialCharacters?.startAnimation(animation)
        llNumbers?.startAnimation(animation)
        llSliderPasswordLength?.startAnimation(animation)


        btnGeneratePassword?.setOnClickListener {
            btnGeneratePassword?.clearAnimation()
            llSpecialCharacters?.clearAnimation()
            llNumbers?.clearAnimation()
            llSliderPasswordLength?.clearAnimation()
            btnGeneratePassword?.translationY = 50.0f
            llSpecialCharacters?.translationY = 50.0f
            llNumbers?.translationY = 50.0f
            llSliderPasswordLength?.translationY = 50.0f


            viewModel.generatePassword(sliderPasswordLength?.value?.toInt(), checkBoxSpecialCharacters, checkBoxNumbers)
            tvShowPassword?.text = viewModel.password
            val animation = AnimationUtils.loadAnimation(this.context, R.anim.fade_in_and_translate)
            tvShowPassword?.startAnimation(animation)
        }
    }

}