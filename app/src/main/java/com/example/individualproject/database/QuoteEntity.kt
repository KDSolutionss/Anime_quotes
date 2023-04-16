package com.example.individualproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotesList")
data class QuoteEntity(val anime:String,
                       val character:String,
                       val quote:String,
                       @PrimaryKey val id:Int=anime.hashCode()/character.hashCode()*quote.hashCode()
)
