package com.example.individualproject.network

import com.example.individualproject.model.Quote
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET

private const val BASE_URL =
    "https://animechan.vercel.app/api/quotes/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface QoutesService {
    @GET(" ")
    suspend fun getQuotes(): List<Quote>
}
object Service {
    val retrofitService : QoutesService by lazy {
        retrofit.create(QoutesService::class.java)
    }

}