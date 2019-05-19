package com.georgevik.blockchaingraph.injection

import com.georgevik.pricechart.data.BlockchainChartApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

const val API_URL = "API_URL"

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideChartApi(retrofit: Retrofit) = retrofit.create(BlockchainChartApi::class.java)

    @Provides
    @Singleton
    fun provideBlockchainApi(@Named(API_URL) baseUrl: String, gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Named(API_URL)
    fun provideBaseUrl(): String {
        return "https://api.blockchain.info"
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val builder = GsonBuilder()
        return builder.create()
    }

    @Provides
    @Singleton
    fun provideApiOkHttpClient(): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
        return okBuilder.build()
    }

}