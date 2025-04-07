package com.example.timer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.example.timer.databinding.ActivityStopwatchBinding
import java.util.Locale

class stopwatch : AppCompatActivity() {
    private lateinit var binding: ActivityStopwatchBinding
    private var startTime = 0L
    private var pauseOffset = 0L
    private var running = false
    private val handler = Handler(Looper.getMainLooper())

    private val updateTimer: Runnable = object : Runnable {
        override fun run() {
            val elapsed = SystemClock.elapsedRealtime() - startTime
            val minutes = (elapsed / 60000).toInt()
            val seconds = (elapsed / 1000 % 60).toInt()
            val milliseconds = (elapsed % 1000 / 10).toInt()

            binding.tvTimer.text = String.format(Locale.getDefault(), "%02d:%02d.%02d", minutes, seconds, milliseconds)

            if (running) handler.postDelayed(this, 10)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStopwatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener {
            if (!running) {
                startTime = SystemClock.elapsedRealtime()
                handler.post(updateTimer)
                running = true
            }
        }

        binding.btnStop.setOnClickListener {
            if (running) {
                handler.removeCallbacks(updateTimer)
                running = false
            }
        }

        binding.btnReset.setOnClickListener {
            handler.removeCallbacks(updateTimer)
            binding.tvTimer.text = "00:00.00"
            running = false
        }

        binding.tvgotm.setOnClickListener {
            val intent = Intent(this, timer::class.java)
            startActivity(intent)
        }
    }
}