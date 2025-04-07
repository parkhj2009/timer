package com.example.timer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.timer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        handler.postDelayed({
            val intent = Intent(this@MainActivity, stopwatch::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}