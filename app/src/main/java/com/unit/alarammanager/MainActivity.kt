package com.unit.alarammanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.unit.alarammanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.setalarm?.setOnClickListener {
            alramManager()
        }


    }

    fun alramManager() {
        val alramManger: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val systemtime = System.currentTimeMillis()
        val getTextt = binding?.alramvalue?.text?.toString()
        val broadCastIntent = Intent(this, TrigerBroadCast::class.java)
        val pendigINternt = PendingIntent.getBroadcast(this,
            100,
            broadCastIntent,
            PendingIntent.FLAG_UPDATE_CURRENT)

        getTextt?.let {
            val trigerTime = systemtime + (it.toLong() * 1000)

            alramManger.set(AlarmManager.RTC_WAKEUP, trigerTime, pendigINternt)

            Toast.makeText(this, "alarm manger set", Toast.LENGTH_SHORT).show()
        }

    }
}