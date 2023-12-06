package com.example.project122

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project122.data.Reservation
import com.example.project122.databinding.ActivityDetailBinding
import java.util.Calendar


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (intent.getIntExtra(ARGS_DOC_ID, 0)) {
            1 -> {
                binding.imgDr1.setImageResource(R.drawable.doc_1)
                binding.tvName.text = "Dr. jack willson"
                binding.tvBranch.text = "Gynecologist and surgeon"
                binding.tvReservation.setOnClickListener {
                    showDatePickerDialog(
                        binding.tvName.text.toString(),
                        binding.tvBranch.text.toString(),
                        R.drawable.doc_1
                    )
                }
            }

            2 -> {
                binding.imgDr1.setImageResource(R.drawable.doc_2)
                binding.tvName.text = "Dr. Andy Brown"
                binding.tvBranch.text = "Neurologist"
                binding.tvReservation.setOnClickListener {
                    showDatePickerDialog(
                        binding.tvName.text.toString(),
                        binding.tvBranch.text.toString(),
                        R.drawable.doc_2
                    )
                }
            }

            3 -> {
                binding.imgDr1.setImageResource(R.drawable.doc_3)
                binding.tvName.text = "Dr. William Smith"
                binding.tvBranch.text = "Pediatrician"
                binding.tvReservation.setOnClickListener {
                    showDatePickerDialog(
                        binding.tvName.text.toString(),
                        binding.tvBranch.text.toString(),
                        R.drawable.doc_3
                    )
                }
            }
        }
    }

    private fun showDatePickerDialog(name: String, branch: String, imgId: Int) {
        val calendar: Calendar = Calendar.getInstance()
        val year: Int = calendar.get(Calendar.YEAR)
        val month: Int = calendar.get(Calendar.MONTH)
        val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this,
            { view: DatePicker?, year1: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = year1.toString() + "-" +
                        String.format("%02d", (monthOfYear + 1)) + "-" +
                        String.format("%02d", dayOfMonth)

                Toast.makeText(this, "$selectedDate 로 예약이 완료되었습니다.", Toast.LENGTH_LONG).show()
                reservationList.add(Reservation(name, branch, imgId, selectedDate))
            }, year, month, day
        )
        datePickerDialog.show()
    }

    companion object {
        val reservationList: MutableList<Reservation> = mutableListOf()

        const val ARGS_DOC_ID = "ARGS_DOC_ID"
        fun create(context: Context?, docId: Int?): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARGS_DOC_ID, docId)
            return intent
        }
    }
}