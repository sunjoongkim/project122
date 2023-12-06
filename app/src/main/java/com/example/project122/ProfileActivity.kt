package com.example.project122

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project122.databinding.ActivityDetailBinding
import com.example.project122.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReservation.setOnClickListener {
            val intent = Intent(this, ReservationActivity::class.java)
            startActivity(intent)
        }
    }


}