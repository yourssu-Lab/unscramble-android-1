package com.yourssu.unscramble

import com.yourssu.unscramble.data.QuizDataSource
import com.yourssu.unscramble.data.QuizDataSourceImpl
import com.yourssu.unscramble.repository.QuizRepository
import com.yourssu.unscramble.repository.QuizRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFruitRepository(dataSource: QuizDataSource): QuizRepository {
        return QuizRepositoryImpl(dataSource)
    }

    @Provides
    fun provideFruitDataSource(): QuizDataSource {
        return QuizDataSourceImpl()
    }
}
