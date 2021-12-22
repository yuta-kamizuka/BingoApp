package com.example.bingo

class BingoManager {
    private var bingonums = (1..75).toMutableList()
    private val rollNumbers = bingonums
    private var nextNumber: Int? = null
    private var lotteryNum = ""
    private var lotteryNumList = mutableListOf<String>()

    //履歴を表示させる処理
    fun lotteryHistory(): String {
        if (nextNumber != null) {
            lotteryNum += "$nextNumber,"
        }
        return lotteryNum
    }

    //次のナンバーを表示させる処理
    fun nextBingo(): String {
        return if (lotteryNumList.size != 75) {
            nextNumber = bingonums.random()
            bingonums.remove(nextNumber)
            lotteryNumList.add(nextNumber.toString())
            nextNumber.toString()
        } else {
            nextNumber = null
            "終了"
        }
    }

    //ナンバーロールをランダム表示させる処理
    fun bingoRoll(): String {
        var rollnumber = ""
        rollnumber = rollNumbers.random().toString()
        return rollnumber
    }
}