package com.example.app05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBacktoFirst = findViewById<Button>(R.id.btnBacktoFirst)
//        val txttest = findViewById<TextView>(R.id.txttest_text)
//        val text = intent.getBundleExtra("key")?.getString("name").toString()

//        txttest.setText(text)

        btnBacktoFirst.setOnClickListener {
            var mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }
    }

    var lastTime: Long = 0
    override fun finish(){
        val currentTime = System.currentTimeMillis()
        if(currentTime - lastTime > 3*1000){
            lastTime = currentTime
            Toast.makeText(this,"再按一下離開",Toast.LENGTH_SHORT).show()
        }else{
            super.finish()
        }
    }
}