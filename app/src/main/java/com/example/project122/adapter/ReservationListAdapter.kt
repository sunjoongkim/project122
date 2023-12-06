package com.example.project122.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project122.data.Reservation
import com.example.project122.databinding.ItemReservationBinding

class ReservationListAdapter(private val dataList: MutableList<Reservation>) :
    RecyclerView.Adapter<ReservationListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemReservationBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(reservation : Reservation) {
            binding.tvName.text = reservation.name
            binding.tvBranch.text = reservation.branch
            binding.tvDate.text = "예약일 : " + reservation.date
            binding.imgDr1.setImageResource(reservation.imgId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemReservationBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reservation = dataList[position]
        holder.bind(reservation)
    }



}