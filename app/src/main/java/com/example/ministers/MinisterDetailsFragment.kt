package com.example.ministers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import ministers.R
import ministers.databinding.FragmentMinisterDetailsBinding
import ministers.databinding.FragmentMinistersBinding

class MinisterDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = MinisterDetailsFragmentArgs.fromBundle(requireArguments())
        println("args ministerdetailsfragement $args ${args.randomId}")
        val binding = DataBindingUtil.inflate<FragmentMinisterDetailsBinding>(
            inflater, R.layout.fragment_minister_details, container, false
        )
        binding.showRand.text = "${args.randomMinister}"
        
        return binding.root
    }
}

