package com.tool.base.retrofit

import com.tool.base.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceConfig {

    fun <API> createService(retrofitApiInterface: Class<API>): API {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(retrofitApiInterface)
    }

}