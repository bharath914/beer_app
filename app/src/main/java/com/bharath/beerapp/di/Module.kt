package com.bharath.beerapp.di

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.bharath.beerapp.data.remote.BeerApi
import com.bharath.beerapp.data.remote.BeerRemoteMediator
import com.bharath.beerapp.local.BeerDatabase
import com.bharath.beerapp.local.BeerEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object Module {

    @Provides
    @Singleton
    fun provideDatabase(app:Application) :BeerDatabase = Room.databaseBuilder(app,BeerDatabase::class.java, "BeerDb").build()

    @Provides
    @Singleton
    fun provideBeerApi():BeerApi{
        return Retrofit.Builder()
            .baseUrl(BeerApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideBeerPager(beerDb:BeerDatabase, beerApi: BeerApi):Pager<Int,BeerEntity>{

        return Pager(
            remoteMediator = BeerRemoteMediator(
                beerDb = beerDb,
                beerApi=beerApi
            )
        , config = PagingConfig(pageSize = 20)
        , pagingSourceFactory = {
            beerDb.dao.pagingSource()
            }
        )
    }


}