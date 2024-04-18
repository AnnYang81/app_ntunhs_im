package com.example.week2_sec;

import java.util.*;

public class GuessGame {
    private var secret = Random().nextInt(100) + 1
    var max_num = 100
    var min_num = 0

    fun guessNumber(guess: Int): String {
        if (guess > max_num || guess < min_num) {
            return "請輸入位於${min_num}~${max_num}的數字"
        }

        when {
            guess > secret -> {
                max_num = guess
                return "你猜的比較大喔"
            }
            guess < secret -> {
                min_num = guess
                return "你猜的比較小喔"
            }
            else -> {
                resetGame()  // Reset game on correct guess
                return "猜對了"
            }
        }
    }

    fun getRangeText(): String = "$min_num~$max_num"

    fun resetGame() {
        secret = Random().nextInt(100) + 1
        max_num = 100
        min_num = 0
    }
}

