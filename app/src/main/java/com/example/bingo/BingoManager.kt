package com.example.bingo

class BingoManager {
    var bingonums = (1..75).toMutableList()
    var nextNumber = 0
    var lotteryNum = ""
    var lotteryNumList = mutableListOf<String>()
    private val end = "終了"

    fun lotteryHistory():String {
        if (nextNumber > 0) {
            lotteryNum += "$nextNumber,"
        }
        return lotteryNum
    }

    fun nextBingo(): String {
        return if (lotteryNumList.size != 75) {
            nextNumber = bingonums.random()
            bingonums.remove(nextNumber)
            lotteryNumList.add(nextNumber.toString())
            nextNumber.toString()
        } else {
            nextNumber = 0
            end
        }
    }
}