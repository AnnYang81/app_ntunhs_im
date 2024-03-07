package com.example.week2_sec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG:String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler(Looper.getMainLooper())

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

            if(guess_num >100 || guess_num<0) {
                title.text = "請輸入位於0~100的數字"
            } else if (validate_num > 0) {
                ans_str = "你猜的比較大喔"
                max_num = guess_num
                tmp = min_num.toString()
                title.text = tmp + "~" + guess_num
            } else if (validate_num < 0) {
                ans_str = "你猜的比較小喔"
                min_num = guess_num
                tmp = max_num.toString()
                title.text = guess_num.toString() +"~"+tmp
            } else {
                title.text = "猜對了"
                handler.postDelayed({
                    Toast.makeText(this,"六秒後重置",Toast.LENGTH_SHORT).show()
                    result.text = "再猜一次"
                    title.text = "下一回合"
                    secret = Random().nextInt(100)+1
                    max_num = 100
                    min_num = 0
                },6000)
            }
            result.text = ans_str
        }

        reset_button.setOnClickListener {
            secret = Random().nextInt(100)+1
            max_num = 100
            min_num = 0
            result.text = "再猜一次"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}