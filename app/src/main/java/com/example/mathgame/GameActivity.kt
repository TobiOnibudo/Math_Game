package com.example.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTime: TextView

    lateinit var textQuestion: TextView
    lateinit var editTextAnswer : EditText

    lateinit var buttonOk: Button
    lateinit var buttonNext: Button

    var correctAnswer = 0
    var userScore = 0
    var userLife = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)
        textQuestion = findViewById(R.id.textViewQuestion)
        editTextAnswer = findViewById(R.id.editTextAnswer)
        buttonOk  = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)


        gameContinue()

        buttonOk.setOnClickListener {
            val input = editTextAnswer.text.toString()

            if(input == "")
            {
                Toast.makeText(applicationContext,"Please write an answer or click the next button",Toast.LENGTH_LONG).show()
            }
            else
            {
                 var userAnswer = input.toInt()

                if(userAnswer == correctAnswer)
                {
                    userScore += 10
                    textQuestion.text = "Congratulations, your answer is correct"
                    textScore.text = userScore.toString()
                }
                else
                {
                    userLife -= 1
                    textQuestion.text = "Sorry, your answer is wrong"
                    textLife.text = userLife.toString()
                }

            }
        }

        buttonNext.setOnClickListener {
            gameContinue()
            editTextAnswer.setText("")
        }



    }

    fun gameContinue()
    {
        val num1 = Random.nextInt(0,100)
        val num2 = Random.nextInt(0,100)

        textQuestion.text = "$num1 + $num2"

        correctAnswer =  num1 + num2
    }
}