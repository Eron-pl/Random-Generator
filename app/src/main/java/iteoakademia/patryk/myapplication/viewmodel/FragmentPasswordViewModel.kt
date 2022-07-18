package iteoakademia.patryk.myapplication.viewmodel

import android.widget.CheckBox
import androidx.core.util.rangeTo
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class FragmentPasswordViewModel : ViewModel() {

    var password: String = ""
    var numbersEnabled: Boolean = false
    var specialCharactersEnabled = false

    val alphabet = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                          "k", "l", "m", "n", "o", "p", "r", "s", "t", "u",
                          "w", "y", "z", "x", "q", "v")

    val specialCharacters = listOf("!", "@", "#", "$", "%", "^")

    fun generatePassword(passwordLength: Int?, checkBoxSpecialCharacters: CheckBox?, checkBoxNumbers: CheckBox?) {
        numbersEnabled = checkBoxNumbers!!.isChecked
        specialCharactersEnabled =  checkBoxSpecialCharacters!!.isChecked
        password = ""

        for(i in 1..passwordLength!!.toInt()) {
            var random = Random.nextInt(10)
            var signToAdd = ""

            var ifUppercase = Random.nextInt(10)
            signToAdd = if (ifUppercase % 3 == 0) alphabet[Random.nextInt(alphabet.size)].uppercase() else alphabet[Random.nextInt(alphabet.size)]

            when(random) {
                in 6..8 -> {
                    if(specialCharactersEnabled) signToAdd = specialCharacters[Random.nextInt(specialCharacters.size)]
                }
                in 9..10 -> {
                    if(numbersEnabled) signToAdd = Random.nextInt(9).toString()
                }
            }
            password += signToAdd
        }
    }

}