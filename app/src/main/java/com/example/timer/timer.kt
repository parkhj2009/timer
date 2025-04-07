package com.example.timer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timer.databinding.ActivityTimerBinding

class timer : AppCompatActivity() {

    private lateinit var binding: ActivityTimerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvgost.setOnClickListener {
            val intent = Intent(this, stopwatch::class.java)
            startActivity(intent)
        }
    }
}