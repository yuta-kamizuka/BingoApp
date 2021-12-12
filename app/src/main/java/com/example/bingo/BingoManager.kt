package com.example.bingo

class BingoManager {
    var bingonums = (1..75).toMutableList()
    private val rollNumbers = bingonums
    var nextNumber = 0
    var lotteryNum = ""
    var lotteryNumList = mutableListOf<String>()

    //履歴を表示させる処理
    fun lotteryHistory():String {
        if (nextNumber > 0) {
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
            val end = "終了"
            nextNumber = 0
            end
        }
    }

    //ナンバーロールをランダム表示させる処理
    fun bingoRoll():String {
        var rollnumber = ""
        rollnumber = rollNumbers.random().toString()
        return rollnumber
    }
}