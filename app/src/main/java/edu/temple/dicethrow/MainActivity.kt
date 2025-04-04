package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        findViewById<Button>(R.id.rollDiceButton).apply{
            setOnClickListener{
                (supportFragmentManager
                    .findFragmentById(R.id.fragmentContainerView) as DieFragment).apply {
                    throwDie()
                }

            }
        }
    }
}