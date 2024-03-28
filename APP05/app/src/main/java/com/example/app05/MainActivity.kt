package com.example.app05

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeActivity = findViewById<Button>(R.id.btnChangeActivity)
//        val btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)
        val btnOpenGuessnum = findViewById<Button>(R.id.guessnum)
//        val edtName = findViewById<TextView>(R.id.edtName_text)

        btnChangeActivity.setOnClickListener {
//            var bundle = Bundle()
//            var name = edtName.text.toString()
//            bundle.putString("name",name)

            var seconIntent = Intent(this,PSR::class.java)
//            seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }

        btnOpenGuessnum.setOnClickListener {
//            var bundle = Bundle()

            var seconIntent = Intent(this,guess_number::class.java)
//            seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }

//        btnOpenBrowser.setOnClickListener {
//            var seconIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
//            startActivity(seconIntent)
//        }
    }
}