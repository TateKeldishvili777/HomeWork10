package com.example.homework10

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var simpleDateFormat = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()
        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

        val receiver: Receiver = Receiver()
        val intentFilter = IntentFilter()

        data.add(ItemsViewModel("App Start Time: " + simpleDateFormat.format(Date())))


        intentFilter.addAction("android.intent.action.SCREEN_ON")
        intentFilter.addAction("android.intent.action.SCREEN_OFF")
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED")
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED")
        registerReceiver(receiver, intentFilter)

    }
}