package com.example.ministers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import ministers.R
import ministers.databinding.FragmentPartiesBinding



class PartiesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPartiesBinding>(
            inflater, R.layout.fragment_parties, container, false)

        binding.showPartiesButton.setOnClickListener{
            val action = PartiesFragmentDirections.actionPartiesFragmentToMinistersFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}
