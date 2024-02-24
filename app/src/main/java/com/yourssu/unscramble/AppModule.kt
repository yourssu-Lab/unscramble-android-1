package com.yourssu.unscramble

import com.yourssu.unscramble.data.FruitDataSource
import com.yourssu.unscramble.data.FruitDataSourceImpl
import com.yourssu.unscramble.repository.FruitRepository
import com.yourssu.unscramble.repository.FruitRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFruitRepository(dataSource: FruitDataSource): FruitRepository {
        return FruitRepositoryImpl(dataSource)
    }

    @Singleton
    @Provides
    fun provideFruitDataSource(): FruitDataSource {
        return FruitDataSourceImpl()
    }
}
