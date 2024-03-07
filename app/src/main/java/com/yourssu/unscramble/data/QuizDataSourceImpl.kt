package com.yourssu.unscramble.data

class QuizDataSourceImpl : QuizDataSource {

    // 문제로 제시할 과일 이름 철자 섞기
    override suspend fun scrambleLetters(word: String): String {
        val letters = word.toCharArray().toMutableList()
        letters.shuffle()
        return letters.joinToString("")
    }

    // 최종 문제 제시, 확인을 위한
    override suspend fun getRandomQuizWord(): QuizSet {
        val originalQuizWord = QuizLists.FRUITS_NAMES.random()
        val scrambledName = scrambleLetters(originalQuizWord)
        return QuizSet(originalQuizWord, scrambledName)
    }
}
