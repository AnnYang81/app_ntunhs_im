package com.example.customization

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.customization.databinding.ActivityMainActivity2InputBinding
import com.example.customization.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity2_input : AppCompatActivity() {
    private lateinit var binding: ActivityMainActivity2InputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainActivity2InputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val sysValue = binding.etSys.text.toString().toIntOrNull() ?: 0
            val diaValue = binding.etDia.text.toString().toIntOrNull() ?: 0
            val hrValue = binding.etHr.text.toString().toIntOrNull() ?: 0

            val resultIntent = Intent()
            resultIntent.putExtra("sys", sysValue)
            resultIntent.putExtra("dia", diaValue)
            resultIntent.putExtra("hr", hrValue)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
