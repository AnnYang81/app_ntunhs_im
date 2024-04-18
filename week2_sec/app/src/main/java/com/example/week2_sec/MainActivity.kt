package com.example.week2_sec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.week2_sec.databinding.ActivityMainBinding

import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG:String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler
    private lateinit var binding: ActivityMainBinding
    private lateinit var game: GuessGame

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    handler = Handler(Looper.getMainLooper())
    game = GuessGame()

    binding.button1.setOnClickListener {
        val guessNum: Int = binding.Name.text.toString().toInt()
        val result: String = game.guessNumber(guessNum)
        binding.result.text = result
        binding.text1.text = game.getRangeText()
    }

    binding.button2.setOnClickListener {
        game.resetGame()
        binding.result.text = "再猜一次"
    }
}

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
