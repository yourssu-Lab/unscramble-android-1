package com.yourssu.unscramble.data

class FruitDataSourceImpl : FruitDataSource {

    // 문제로 제시할 과일 이름 철자 섞기
    override suspend fun scrambleLetters(word: String): String {
        val letters = word.toCharArray().toMutableList()
        letters.shuffle()
        return letters.joinToString("")
    }

    // 최종 문제 제시, 확인을 위한
    override suspend fun getRandomQuestionFruitName(): Fruit {
        val originalFruitName = FruitNames.NAMES.random()
        val scrambledName = scrambleLetters(originalFruitName)
        return Fruit(originalFruitName, scrambledName)
    }

    // 정답 확인
    override suspend fun checkAnswer(userAnswer: String, answer: String): Boolean {
        return userAnswer.uppercase() == answer
    }
}
