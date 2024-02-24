package com.yourssu.unscramble.repository

import com.yourssu.unscramble.data.Fruit
import com.yourssu.unscramble.data.FruitDataSource

class FruitRepositoryImpl(private val fruitDataSource: FruitDataSource) : FruitRepository {

    override suspend fun scrambleLetters(word: String): String {
        return fruitDataSource.scrambleLetters(word)
    }

    override suspend fun getRandomQuestionFruitName(): Fruit {
        return fruitDataSource.getRandomQuestionFruitName()
    }

    override suspend fun checkAnswer(userAnswer: String, answer: String): Boolean {
        return fruitDataSource.checkAnswer(userAnswer, answer)
    }
}
