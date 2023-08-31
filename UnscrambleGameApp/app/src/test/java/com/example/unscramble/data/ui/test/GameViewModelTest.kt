package com.example.unscramble.data.ui.test

import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.getUnscrambledWord
import com.example.unscramble.ui.GameViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test


class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset(){
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambleWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value

        // Assert that checkUserGuess() method updates isGuessedWordWrong is updated correctly.
        assertFalse(currentGameUiState.isGuessWordWrong)

        // Assert that score is updated correctly.
        assertEquals(20, currentGameUiState.score)

    }

    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }

//    Note: The code above uses the thingUnderTest_TriggerOfTest_ResultOfTest format to name the test function name:
//
//    thingUnderTest = gameViewModel
//    TriggerOfTest = CorrectWordGuessed
//    ResultOfTest = ScoreUpdatedAndErrorFlagUnset


    //[Error Path]
    // check : score unchange and isGuessWordWrong = true
    @Test
    fun gameViewModel_IncorrectWordGuess_ErrorFlagSet(){
        val incorrectPlayerWord = "and"

        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()

        val currentGameUiState = viewModel.uiState.value
        // Assert that score is unchanged
        assertEquals(0, currentGameUiState.score)
        // Assert that checkUserGuess() method updates isGuessedWordWrong correctly
        assertTrue(currentGameUiState.isGuessWordWrong)
    }


    //[Boundary case]
    //when GameViewModel initialized :
    //currentWordCount = 1, score = 0, isGuessWord = false, isGameOver = false

    @Test
    fun gameViewModel_Initialization_FirstWordLoaded(){
        val gameUiState = viewModel.uiState.value

        val unScrambleWord = getUnscrambledWord(gameUiState.currentScrambleWord)
        // Assert that current word is scrambled.
        assertNotEquals(unScrambleWord, gameUiState.currentScrambleWord)
        // Assert that currentWordCount is set to 1
        assertEquals(1, gameUiState.currentWordCount)
        // Assert that score = 0
        assertEquals(0, gameUiState.score)
        // Assert that isGuessWord = false
        assertFalse(gameUiState.isGuessWordWrong)
        //Assert that isGameOver = false
        assertFalse(gameUiState.isGameOver)

    }




}