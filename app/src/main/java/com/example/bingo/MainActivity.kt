package com.example.bingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.bingo.databinding.ActivityMainBinding
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val bingoManager = BingoManager()


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //クリックすると上部にランダムナンバーをロールさせる
        binding.lotteryStart.setOnClickListener {
            binding.resultListView.text = bingoManager.lotteryHistory()
            timer(period = 100) {
                handler.post {
                    binding.resultText.text = bingoManager.bingoRoll()
                }
                //クリックするとビンゴナンバーが出る、2回目から下に履歴として表示される
                //ランダムナンバーのロールを止める
                binding.lotteryStop.setOnClickListener {
                    cancel()
                    binding.resultText.text = bingoManager.nextBingo()
                }
            }
        }
    }
}