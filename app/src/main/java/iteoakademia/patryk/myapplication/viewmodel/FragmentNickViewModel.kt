package iteoakademia.patryk.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class FragmentNickViewModel : ViewModel() {
    val prefixes = listOf("To", "Ke", "Ne", "Mal", "De", "Ro", "Ka","Lo", "Ve", "Hal", "Di")
    val postfixes = listOf("nar", "mer", "lof", "nel", "rek", "gon", "lef", "met", "ark", "kek")

    var nick = "Nick"

    fun generateNick() {
        nick = prefixes[Random.nextInt(prefixes.size)] + postfixes[Random.nextInt(postfixes.size)]
    }
}