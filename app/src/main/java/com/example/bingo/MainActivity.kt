package com.example.bingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bingo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var bingonums = (1..75).toMutableList()
    var nextNumber = 0
    var lotteryNum = ""
    var lotteryNumList = mutableListOf<Int>()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lottery.setOnClickListener {
            if (nextNumber > 0){
                lotteryNum += "$nextNumber,"
                binding.resultListView.text = lotteryNum
            }

            if (lotteryNumList.size != 75) {
                nextNumber = bingonums.random()
                bingonums.remove(nextNumber)
                lotteryNumList.add(nextNumber)
                binding.resultText.text = nextNumber.toString()
            } else {
                binding.resultText.text = "終了"
                nextNumber = 0
            }
        }
    }
}