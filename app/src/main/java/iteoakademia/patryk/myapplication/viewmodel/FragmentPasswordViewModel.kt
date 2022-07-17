package iteoakademia.patryk.myapplication.viewmodel

import androidx.core.util.rangeTo
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class FragmentPasswordViewModel : ViewModel() {

    var password: String = ""

    val alphabet = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                          "k", "l", "m", "n", "o", "p", "r", "s", "t", "u",
                          "w", "y", "z", "x", "q", "v")

    val specialCharacters = listOf("!", "@", "#", "$", "%", "^")

    fun generatePassword(passwordLength: Int?) {
        password = ""
        for(i in 1..passwordLength!!.toInt()) {
            var random = Random.nextInt(10)
            var signToAdd = ""

            when(random) {
                in 1..5 -> {
                    var ifUppercase = Random.nextInt(10)
                    signToAdd = if (ifUppercase % 3 == 0) alphabet[Random.nextInt(alphabet.size)].uppercase() else alphabet[Random.nextInt(alphabet.size)]
                }
                in 6..8 -> {
                    signToAdd = Random.nextInt(9).toString()
                }
                else -> {
                    signToAdd = specialCharacters[Random.nextInt(specialCharacters.size)]
                }
            }
            password += signToAdd
        }
    }

}