package com.example.kontrolinis

import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View

import android.widget.Toast
import com.example.kontrolinis.databinding.ActivityMainBinding
import android.os.Handler

import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var alarmSound: Ringtone? = null
    private val alarmDelay = 5000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val defaultAlarmUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        alarmSound = RingtoneManager.getRingtone(applicationContext, defaultAlarmUri)

        fun playAlarmSound() {
            if (!alarmSound?.isPlaying!!) {
                alarmSound?.play()
                Handler(Looper.getMainLooper()).postDelayed({
                    alarmSound?.stop()
                }, 6000)
            }
        }
        fun stopAlarmSound() {
            if (alarmSound?.isPlaying == true) {
                alarmSound?.stop()
            }
            else {
                Toast.makeText(this,"Joks signalas nenustatytas", Toast.LENGTH_SHORT).show()
            }
        }

        binding.button2.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                playAlarmSound()
            }, alarmDelay)

        }
        binding.button3.setOnClickListener {
            stopAlarmSound()
        }
        binding.button4.setOnClickListener {
            binding.button6.visibility = View.VISIBLE
            binding.button7.visibility = View.VISIBLE
            binding.button8.visibility = View.VISIBLE
            binding.button9.visibility = View.VISIBLE
        }
        binding.button6.setOnClickListener {
            val hour = binding.timePicker.hour
            val minute = binding.timePicker.minute

            val currentTime = Calendar.getInstance()
            val currentHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val currentMinute = currentTime.get(Calendar.MINUTE)

            if (hour == currentHour && minute == currentMinute) {
                Toast.makeText(this,"veikia", Toast.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    playAlarmSound()
                }, alarmDelay)
            }
        }
        binding.button7.setOnClickListener {
            stopAlarmSound()
        }
        binding.button8.setOnClickListener {
            binding.timePicker.visibility = View.VISIBLE
        }






    }
}