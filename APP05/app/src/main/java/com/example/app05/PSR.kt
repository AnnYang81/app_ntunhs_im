package com.example.app05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class PSR : AppCompatActivity() {
    private lateinit var txtCom: TextView
    private lateinit var result: TextView
    private lateinit var btnPaper: ImageButton
    private lateinit var btnRock: ImageButton
    private lateinit var btnScissors: ImageButton
    private lateinit var imageView: ImageView


    enum class Choice {
        Paper,ROCK,SCISSORS
    }

    fun getChoiceString (choice: Choice): Int {
        return when (choice) {
            Choice.Paper -> R.string.paper
            Choice.ROCK -> R.string.rock
            Choice.SCISSORS -> R.string.scissors
        }
    }
    fun getChoicePic (choice: Choice): Int {
        return when (choice) {
            Choice.Paper -> R.drawable.paper
            Choice.ROCK -> R.drawable.rock
            Choice.SCISSORS -> R.drawable.scissor
        }
    }

    fun playGame (playerChoice: Choice) {
        val choices = Choice.values()
        val computerchoice = choices[Random().nextInt(choices.size)]

        when {
            playerChoice == computerchoice -> {
                txtCom.setText(getChoiceString(computerchoice))
                imageView.setImageResource(getChoicePic(computerchoice))
                result.setText(R.string.draw)
            }
            (playerChoice == Choice.SCISSORS && computerchoice == Choice.Paper) ||
                    (playerChoice == Choice.ROCK && computerchoice == Choice.SCISSORS) ||
                    (playerChoice == Choice.Paper && computerchoice == Choice.ROCK )->{
                txtCom.setText(getChoiceString(computerchoice))
                imageView.setImageResource(getChoicePic(computerchoice))
                result.setText(R.string.win)
            }
            else -> {
                txtCom.setText(getChoiceString(computerchoice))
                imageView.setImageResource(getChoicePic(computerchoice))
                result.setText(R.string.lose)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_psr)

        val btnBacktoFirst = findViewById<Button>(R.id.btnBacktoFirst)

        txtCom = findViewById(R.id.txtCom)
        result = findViewById(R.id.result)
        btnPaper = findViewById(R.id.btnPaper)
        btnRock = findViewById(R.id.btnRock)
        btnScissors = findViewById(R.id.btnScissors)
        imageView = findViewById(R.id.imageView)

        btnBacktoFirst.setOnClickListener {
            var mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }

        btnPaper.setOnClickListener {
            playGame(Choice.Paper)
        }
        btnRock.setOnClickListener {
            playGame(Choice.ROCK)
        }
        btnScissors.setOnClickListener {
//            imageView.setImageResource(R.drawable.scissor)
            playGame(Choice.SCISSORS)
        }
    }
}