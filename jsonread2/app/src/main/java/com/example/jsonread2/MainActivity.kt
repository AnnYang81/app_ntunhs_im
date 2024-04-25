package com.example.jsonread2

import android.media.AudioPlaybackCaptureConfiguration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.json.JSONObject
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity(), CoroutineScope {
    val TAG = MainActivity::class.java.simpleName
    val job = Job()+Dispatchers.IO
    override val coroutineContext: CoroutineContext
    get() = job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch {
            val json = URL("https://api.jsonserve.com/KizxuV").readText()
            Log.w(TAG,json)
            parseJson(json)
        }
    }

    private fun parseJson(json: String) {
        val jsonObject = JSONObject(json)

        val array = jsonObject.getJSONArray("singers")
        for (i in 0 until array.length()) {
            val w = array.getJSONObject(i)
            val name = w.getString("name")
            val agency = w.getString("agency")
            Log.d(TAG, "onCreate: $name : $agency")
        }
    }
}