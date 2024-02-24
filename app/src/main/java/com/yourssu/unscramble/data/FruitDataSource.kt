package com.yourssu.unscramble.data

interface FruitDataSource {
    suspend fun getRandomQuestionFruitName(): Fruit
    suspend fun scrambleLetters(word: String): String

    suspend fun checkAnswer(
        userAnswer: String,
        answer: String,
    ): Boolean
}
