package iteoakademia.patryk.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import iteoakademia.patryk.myapplication.R
import iteoakademia.patryk.myapplication.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFrameLayout, viewModel.fragmentNick)
            commit()
        }

        val btnNick = findViewById<ImageButton>(R.id.btnNick)
        val btnPassword = findViewById<ImageButton>(R.id.btnPassword)

        btnNick.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrameLayout, viewModel.fragmentNick)
                commit()
            }
        }

        btnPassword.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrameLayout, viewModel.fragmentPassword)
                commit()
            }
        }
    }
}