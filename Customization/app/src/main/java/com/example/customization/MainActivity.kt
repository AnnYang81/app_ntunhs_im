package com.example.customization

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.Date
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customization.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: RecordAdapter
    private val TAG = "MainActivity"
    private var records = Bprecords(emptyList())
    private val gson = Gson()

    companion object {
        const val REQUEST_CODE_ADD_RECORD = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarMain.inflateMenu(R.menu.menu)

        binding.toolbarMain.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menu_add -> {
                    val intent = Intent(this, MainActivity2_input::class.java)
                    startActivityForResult(intent, REQUEST_CODE_ADD_RECORD)
                }
            }
            true
        }

        mAdapter = RecordAdapter(this, Bprecords(emptyList()))
        binding.recordRecycler.adapter = mAdapter
        binding.recordRecycler.layoutManager = LinearLayoutManager(this)
        val records = Bprecords(mutableListOf(
            bprecord("2024-05-09", 120, 80, 72),
            bprecord("2024-05-09", 120, 80, 75),
            bprecord("2024-05-10", 118, 78, 70),
        ))
        mAdapter.updateData(records)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE_ADD_RECORD && resultCode == Activity.RESULT_OK){
            val sys = data?.getIntExtra("sys", 0) ?: 0
            val dia = data?.getIntExtra("dia", 0) ?: 0
            val hr = data?.getIntExtra("hr", 0) ?: 0
            val newRecord = bprecord(getCurrentDateTime(), sys, dia, hr)

            mAdapter.addRecord(newRecord)
        }
    }

    fun getCurrentDateTime(): String {
        val current = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.format(current)
}
}
