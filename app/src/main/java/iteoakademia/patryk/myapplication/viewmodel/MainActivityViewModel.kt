package iteoakademia.patryk.myapplication.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import iteoakademia.patryk.myapplication.view.FragmentNick
import iteoakademia.patryk.myapplication.view.FragmentPassword

class MainActivityViewModel : ViewModel() {

    val fragmentNick = FragmentNick()
    val fragmentPassword = FragmentPassword()

    fun showToast(fragmentName: String, context: Context) {
        Toast.makeText(context, fragmentName, Toast.LENGTH_SHORT).show()
    }
}