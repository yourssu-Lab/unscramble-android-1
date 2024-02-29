package com.yourssu.unscramble.repository

import com.yourssu.unscramble.data.QuizSet

interface QuizRepository {
    suspend fun getRandomQuizWord(): QuizSet
    suspend fun scrambleLetters(word: String): String
    suspend fun checkAnswer(
        userAnswer: String,
        answer: String,
    ): Boolean
}
