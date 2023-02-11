package com.faanghut.servicecommunication

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val serviceBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.i("onReceive", "$intent Extras - ${intent.extras.toString()}")
        }
    }

    override fun onCreate() {
        super.onCreate()

        Log.i("Service", "Created")
        val intentFilter = IntentFilter(ConstantKeys.NOTHING_TO_SEE_HERE_BROADCAST)
        registerReceiver(serviceBroadcastReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(serviceBroadcastReceiver)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}