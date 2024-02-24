package com.yourssu.unscramble.repository

import com.yourssu.unscramble.data.Fruit

interface FruitRepository {
    suspend fun getRandomQuestionFruitName(): Fruit
    suspend fun scrambleLetters(word: String): String
    suspend fun checkAnswer(
        userAnswer: String,
        answer: String,
    ): Boolean
}