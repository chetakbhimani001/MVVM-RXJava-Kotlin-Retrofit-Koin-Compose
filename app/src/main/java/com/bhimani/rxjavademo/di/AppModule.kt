package com.bhimani.rxjavademo.di

import com.bhimani.rxjavademo.repository.network.ApiServices
import com.bhimani.rxjavademo.repository.network.NetworkRepository
import com.bhimani.rxjavademo.utils.Constants
import com.bhimani.rxjavademo.viewmodel.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    factory { provideOkHttpClient() }
    factory { provideUserApi(get()) }
    single { provideRetrofit(get()) }
    factory { NetworkRepository(get()) }
    viewModel { MainViewModel(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(Constants.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
}

fun provideUserApi(retrofit: Retrofit): ApiServices = retrofit.create(ApiServices::class.java)

private val interceptor = run {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.apply {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }
}
