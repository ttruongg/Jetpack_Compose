package com.example.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> =
        _uiState.asStateFlow() // this asStateFlow make this mutable state flow a read-only state flow.
    private lateinit var currentWord: String
    private val usedWord: MutableSet<String> = mutableSetOf()

    public var userGuess by mutableStateOf("")
        private set

    private fun pickRandomAndShuffle(): String {
        currentWord = allWords.random()
        if (usedWord.contains(currentWord)) {
            return pickRandomAndShuffle()
        } else {
            usedWord.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }


    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle()
        while (tempWord.equals(word)) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    //this function use start and restart the game.
    fun resetGame(){
        usedWord.clear()
        _uiState.value = GameUiState(currentScrambleWord = pickRandomAndShuffle())
    }

    init {
        resetGame()
    }

    fun updateUserGuess(guessWord: String){
        userGuess = guessWord
    }

    fun checkUserGuess(){
        if (userGuess.equals(currentWord, ignoreCase = true)){
            val updatedScope = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScope)
        } else{
            _uiState.update { currentState ->
                currentState.copy(isGuessWordWrong = true)

            }

        }
        //Reset outlinetextfile
        updateUserGuess("")
    }

    private fun updateGameState(updatedScore: Int){
        _uiState.update { currentState ->
            currentState.copy(
                isGuessWordWrong = false,
                currentScrambleWord = pickRandomAndShuffle(),
                score = updatedScore,
                currentWordCount = currentState.currentWordCount.inc()
            )

        }
    }

    fun SkipWord(){
        updateGameState(_uiState.value.score)
        updateUserGuess("")
    }
}