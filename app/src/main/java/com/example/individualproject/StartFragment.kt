package com.example.individualproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.individualproject.databinding.FragmentStartBinding



class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater)
        binding.button6.setOnClickListener { findNavController().navigate(R.id.action_startFragment_to_jokesList) }
        binding.button7.setOnClickListener { findNavController().navigate(R.id.action_startFragment_to_favsFragment) }
        return binding.root
    }


}