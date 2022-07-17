package iteoakademia.patryk.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import iteoakademia.patryk.myapplication.view.FragmentNick
import iteoakademia.patryk.myapplication.view.FragmentPassword

class MainActivityViewModel : ViewModel() {

    val fragmentNick = FragmentNick()
    val fragmentPassword = FragmentPassword()
}