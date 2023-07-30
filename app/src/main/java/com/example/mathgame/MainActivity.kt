package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var addition : Button
    lateinit var subtraction : Button
    lateinit var multi: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addition = findViewById(R.id.buttonAdd)
        subtraction = findViewById(R.id.buttonSub)
        multi = findViewById(R.id.buttonMulti)

        addition.setOnClickListener {
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            intent.putExtra("title","Addition")
            startActivity(intent)

        }

        subtraction.setOnClickListener {
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            intent.putExtra("title","Subtraction")
            startActivity(intent)
        }

        multi.setOnClickListener {
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            intent.putExtra("title","Multiplication")
            startActivity(intent)
        }

    }
}