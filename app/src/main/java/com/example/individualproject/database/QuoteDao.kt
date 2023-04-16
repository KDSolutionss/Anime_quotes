package com.example.individualproject.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE


@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotesList")
    fun getAll(): LiveData<List<QuoteEntity>>

    @Insert(onConflict = REPLACE)
    fun insert(quote: QuoteEntity)

    @Update
    fun update(quote: QuoteEntity)

    @Delete
    fun delete(quote: QuoteEntity)

}