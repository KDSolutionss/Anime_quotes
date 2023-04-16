package com.example.individualproject.database

import com.example.individualproject.model.Quote

class QuotesRepository(private val quotes:QuoteDao) {
    fun getAllUsers(): List<Quote> {
        return quotes.getAll().value?.map { it->Quote(it.anime,it.character,it.quote) }
            ?: listOf(Quote("","",""))

    }

    fun insertQuote(quote: Quote) {
        quotes.insert(QuoteEntity(quote.anime, quote.character, quote.quote))
    }

}