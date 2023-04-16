package com.example.individualproject.data

import com.example.individualproject.model.Quote
import com.example.individualproject.network.Service

class ServiceRepository {

    suspend fun loadQuotes(): List<Quote> {
        return Service.retrofitService.getQuotes()
    }
}