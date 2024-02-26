package com.yourssu.unscramble

import com.yourssu.unscramble.data.FruitDataSource
import com.yourssu.unscramble.data.FruitDataSourceImpl
import com.yourssu.unscramble.repository.FruitRepository
import com.yourssu.unscramble.repository.FruitRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideFruitRepository(dataSource: FruitDataSource): FruitRepository {
        return FruitRepositoryImpl(dataSource)
    }

    @Provides
    fun provideFruitDataSource(): FruitDataSource {
        return FruitDataSourceImpl()
    }
}
