package com.example.individualproject

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.individualproject.adapter.FavsAdapter
import com.example.individualproject.data.MyViewModel
import com.example.individualproject.data.ViewModelFactory
import com.example.individualproject.database.ItemRoomDatabase
import com.example.individualproject.database.QuoteDao
import com.example.individualproject.database.QuotesRepository
import com.example.individualproject.databinding.FragmentFavsBinding
import com.example.individualproject.model.Quote


class FavsFragment : Fragment() {
    lateinit var binding: FragmentFavsBinding

    val viewModelka:MyViewModel
    by activityViewModels{ ViewModelFactory(Application()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavsBinding.inflate(inflater)

        return binding.root
    }



    override fun onStart() {
        super.onStart()
        viewModelka.update()
        viewModelka.quotes.observe(viewLifecycleOwner
        ) { binding.recyclerView.adapter = viewModelka.quotes.value?.let { FavsAdapter(it) } }

    }
}