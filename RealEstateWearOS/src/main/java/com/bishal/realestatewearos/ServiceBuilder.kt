package com.bishal.realestatewearos

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL =
//        "http://192.168.251.1:90/"
        "http://10.0.2.2:90/"
    var token: String? = null
    //    private val okHttp = OkHttpClient.Builder()
    private val logger: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttp: OkHttpClient.Builder= OkHttpClient.Builder().addInterceptor(logger)
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
    //create retrofit instance
    private val retrofit = retrofitBuilder.build()

    //generic function
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

    // Load image path
    fun loadImagePath(): String {
        val arr = BASE_URL.split("/").toTypedArray()
        return arr[0] + "//" + arr[1] + arr[2] + "/pictures"
    }
}