package com.example.bingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bingo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val bingoManager = BingoManager()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lotteryStart.setOnClickListener {
            binding.resultListView.text = bingoManager.lotteryHistory()
            binding.resultText.text = bingoManager.nextBingo()
        }
    }
}