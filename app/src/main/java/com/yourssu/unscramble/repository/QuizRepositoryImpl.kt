package com.yourssu.unscramble.repository

import com.yourssu.unscramble.data.QuizDataSource
import com.yourssu.unscramble.data.QuizSet

class QuizRepositoryImpl(private val quizDataSource: QuizDataSource) : QuizRepository {

    override suspend fun scrambleLetters(word: String): String {
        return quizDataSource.scrambleLetters(word)
    }

    override suspend fun getRandomQuizWord(): QuizSet {
        return quizDataSource.getRandomQuizWord()
    }

    override suspend fun checkAnswer(userAnswer: String, answer: String): Boolean {
        return quizDataSource.checkAnswer(userAnswer, answer)
    }
}
