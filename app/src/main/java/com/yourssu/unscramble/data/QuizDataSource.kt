package com.yourssu.unscramble.data

interface QuizDataSource {
    suspend fun getRandomQuizWord(): QuizSet
    suspend fun scrambleLetters(word: String): String

    suspend fun checkAnswer(
        userAnswer: String,
        answer: String,
    ): Boolean
}
