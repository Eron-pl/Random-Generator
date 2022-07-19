package iteoakademia.patryk.myapplication.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import iteoakademia.patryk.myapplication.R
import iteoakademia.patryk.myapplication.viewmodel.FragmentNickViewModel

class FragmentNick : Fragment() {

    companion object {
        fun newInstance() = FragmentNick()
    }

    private lateinit var viewModel: FragmentNickViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_nick, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentNickViewModel::class.java)

        val animation = AnimationUtils.loadAnimation(this.context, R.anim.fade_in_and_translate)

        val btnGenerateNick = getView()?.findViewById<Button>(R.id.btnGenerateNick)
        val tvShowNick = getView()?.findViewById<TextView>(R.id.tvShowNick)

        tvShowNick?.startAnimation(animation)
        btnGenerateNick?.startAnimation(animation)

        btnGenerateNick?.setOnClickListener {
            btnGenerateNick?.clearAnimation()
            btnGenerateNick.translationY = 50.0f

            viewModel.generateNick()
            tvShowNick?.text = viewModel.nick
            tvShowNick?.startAnimation(animation)
        }
    }

}