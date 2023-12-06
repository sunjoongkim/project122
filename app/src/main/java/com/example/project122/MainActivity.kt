package com.example.project122

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project122.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.layout1.setOnClickListener { start(1) }
        binding.layout2.setOnClickListener { start(2) }
        binding.layout3.setOnClickListener { start(3) }
        binding.layoutDr1.setOnClickListener { start(1) }
        binding.layoutDr2.setOnClickListener { start(2) }
        binding.layoutDr3.setOnClickListener { start(3) }
    }

    private fun start(docId: Int) {
        startActivity(DetailActivity.create(this, docId))
    }
}