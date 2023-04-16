package com.example.individualproject.data

import android.app.Application
import androidx.lifecycle.*
import com.example.individualproject.database.ItemRoomDatabase
import com.example.individualproject.database.QuoteEntity
import com.example.individualproject.database.QuotesRepository
import com.example.individualproject.model.Quote

class ViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MyViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
class MyViewModel(app: Application) : ViewModel() {
    private val userDao = ItemRoomDatabase.getDatabase(app).itemDao()


    var quotes: LiveData<List<Quote>> =
        userDao.getAll().map { it.map { x->Quote(x.anime,x.character,x.quote) } }

    fun insertMyEntity(entity: QuoteEntity) {
        userDao.insert(entity)
    }
    fun update()
    {
        quotes=userDao.getAll().map { it.map { x->Quote(x.anime,x.character,x.quote) } }
    }


}