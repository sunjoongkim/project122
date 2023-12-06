package com.example.project122

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project122.adapter.ReservationListAdapter
import com.example.project122.databinding.ActivityDetailBinding
import com.example.project122.databinding.ActivityReservationBinding

class ReservationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (DetailActivity.reservationList.isEmpty()) {
            binding.tvEmpty.visibility = View.VISIBLE
        }

        DetailActivity.reservationList.sortBy { it.date }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ReservationListAdapter(DetailActivity.reservationList)
    }
}