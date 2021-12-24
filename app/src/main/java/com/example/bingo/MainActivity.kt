package com.example.bingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.bingo.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val bingoManager = BingoManager()

    private lateinit var binding: ActivityMainBinding
    private var timer: Timer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //クリックすると上部にランダムナンバーをロールさせる.2回目から下に履歴を表示される
        binding.lotteryStart.setOnClickListener {
            binding.lotteryStart.isEnabled = false
            binding.lotteryStop.isEnabled = true
            binding.resultListView.text = bingoManager.lotteryHistory()

            timer = Timer()
            timer!!.schedule(0,100) {
                handler.post {
                    binding.resultText.text = bingoManager.bingoRoll()
                }
            }
        }

        //クリックするとビンゴナンバーが出る、ランダムナンバーのロールを止める
        //Timerを再度インスタンス化する事でロールを再度使えるようにする。
        binding.lotteryStop.setOnClickListener {
            binding.lotteryStart.isEnabled = true
            binding.lotteryStop.isEnabled = false
            binding.resultText.text = bingoManager.nextBingo()

            timer!!.cancel()
            timer = null
        }
    }
}