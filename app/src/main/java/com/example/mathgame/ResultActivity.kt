package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var  result: TextView
    private lateinit var playAgain : Button
    private lateinit var  exit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        result = findViewById(R.id.textViewResult)
        playAgain = findViewById(R.id.buttonAgain)
        exit = findViewById(R.id.buttonExit)
        val score = intent.getIntExtra("score",0)

        result.text = "Your score: "+ score

        playAgain.setOnClickListener {
          val intent = Intent(this@ResultActivity, MainActivity::class.java)
          startActivity(intent)
          finish()
        }

        exit.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME )
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}