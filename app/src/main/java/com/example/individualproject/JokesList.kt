package com.example.individualproject

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.individualproject.adapter.ItemAdapter
import com.example.individualproject.data.MyViewModel
import com.example.individualproject.data.ServiceRepository
import com.example.individualproject.data.ViewModelFactory
import com.example.individualproject.database.ItemRoomDatabase
import com.example.individualproject.database.QuotesRepository
import com.example.individualproject.databinding.FragmentJokesListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class JokesList : Fragment() {
    lateinit var binding: FragmentJokesListBinding
    // TODO: Rename and change types of parameters
    val viewModelka:MyViewModel
            by activityViewModels{ ViewModelFactory(Application()) }
    val repo=ServiceRepository()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.title = "Your Title";
        binding = FragmentJokesListBinding.inflate(inflater)
        CoroutineScope(Dispatchers.Main).launch {  binding.recyclerView.adapter =
            context?.let { repo.loadQuotes()
                ItemAdapter(repo.loadQuotes(), viewModelka)
                 }

        }



        return binding.root
    }

}