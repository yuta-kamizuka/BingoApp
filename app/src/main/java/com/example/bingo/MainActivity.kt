package com.example.bingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bingo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    var bingonums = (1..75).toMutableList()
//    var nextNumber = 0
//    var lotteryNum = ""
//    var lotteryNumList = mutableListOf<Int>()

    private val bingoManager = BingoManager()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lottery.setOnClickListener {
            binding.resultListView.text = bingoManager.lotteryHistory()
            binding.resultText.text = bingoManager.nextBingo()
        }
    }
}