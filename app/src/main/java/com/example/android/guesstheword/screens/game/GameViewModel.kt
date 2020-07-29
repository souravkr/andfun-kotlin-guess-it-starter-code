package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel



// The list of words - the front of the list is the next word to guess
private lateinit var wordList: MutableList<String>

class GameViewModel : ViewModel() {
    var word = ""

    // The current score
    var score = 0
    init{
        resetList()
        nextWord()
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("sr", "view Model destroyed")
    }


/**
 * Resets the list of words and randomizes the order
 */
private fun resetList() {
    wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
    )
    wordList.shuffle()
}
/**
 * Moves to the next word in the list
 */
private fun nextWord() {
    //Select and remove a word from the list
    if (wordList.isEmpty()) {
        // gameFinished()
    } else {
        word = wordList.removeAt(0)
    }
}

 fun onSkip() {
    score--
    nextWord()
}

 fun onCorrect() {
    score++
    nextWord()
}

}