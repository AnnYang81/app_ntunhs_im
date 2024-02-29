package com.example.week2_sec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = findViewById<TextView>(R.id.text1)
        val result = findViewById<TextView>(R.id.result)
        val editText = findViewById<EditText>(R.id.Name)
        val guess_button = findViewById<Button>(R.id.button1)
        val reset_button = findViewById<Button>(R.id.button2)
        var validate_num:Int
        var secret : Int = Random().nextInt(100)+1
        var tmp : String
        var max_num:Int = 100
        var min_num:Int = 0

        guess_button.setOnClickListener {
            var guess_num: Int = editText.text.toString().toInt()
            validate_num = guess_num - secret
            var ans_str: String = "猜對了"

            if (validate_num > 0) {
                ans_str = "你猜的比較大喔"
                max_num = guess_num
                tmp = min_num.toString()
                title.text = tmp + "~" + guess_num
            } else if (validate_num < 0) {
                ans_str = "你猜的比較小喔"
                min_num = guess_num
                tmp = max_num.toString()
                title.text = guess_num.toString() +"~"+tmp
            }else{
                title.text = "猜對了"
            }
            result.text = ans_str
        }

        reset_button.setOnClickListener {
            secret = Random().nextInt(10)+1
            max_num = 100
            min_num = 0
            result.text = "再猜一次"
        }
    }
}

