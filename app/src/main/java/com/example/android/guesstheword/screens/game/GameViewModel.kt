package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// The list of words - the front of the list is the next word to guess
private lateinit var wordList: MutableList<String>

class GameViewModel : ViewModel() {
    private var _word = MutableLiveData<String>()

    // The current score
    private var _score = MutableLiveData<Int>()

    private var _isGameFinished = MutableLiveData<Boolean>()

    val isGameFinished : LiveData<Boolean>
      get() = _isGameFinished

    val score :LiveData<Int>
      get() = _score

    val word : LiveData<String>
        get() = _word

    init{
        _isGameFinished.value = false
        resetList()
        nextWord()
        _score.value = 0
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
       _isGameFinished.value = true
    } else {
        _word.value = wordList.removeAt(0)
    }
}

 fun onSkip() {
    _score.value =(_score.value)?.minus(1)
    nextWord()
}

 fun onCorrect() {
    _score.value = (_score.value)?.plus(1)
    nextWord()
}

    fun onGameFinishCOmplete(){
        _isGameFinished.value = false
    }

}