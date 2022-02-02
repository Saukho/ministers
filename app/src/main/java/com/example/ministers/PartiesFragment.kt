package com.example.ministers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import ministers.R
import ministers.databinding.ActivityMainBinding
import ministers.databinding.FragmentMinistersBinding
import ministers.databinding.FragmentPartiesBinding


class PartiesFragment : Fragment() {
    private lateinit var binding: FragmentPartiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPartiesBinding>(
            inflater, R.layout.fragment_parties, container, false)

        binding.parties = this

        binding.showPartiesButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER") {
                view:View -> view.findNavController().navigate(R.id.action_partiesFragment_to_ministersFragment2) }
        return binding.root
    }
}
