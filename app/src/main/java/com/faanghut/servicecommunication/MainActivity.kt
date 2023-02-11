package com.faanghut.servicecommunication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startMyService()
        clickListeners()
    }

    private fun clickListeners() {
        val btn = findViewById<Button>(R.id.btn_send_data)
        btn.setOnClickListener {
            sendDataToService()
        }
    }

    private fun startMyService() {
        startService(Intent(baseContext, MyService::class.java))
    }

    private fun sendDataToService() {
        val intent = Intent(ConstantKeys.NOTHING_TO_SEE_HERE_BROADCAST)
        intent.putExtra("data", "keep going lol")
        sendBroadcast(intent)
    }
}