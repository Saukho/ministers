package com.example.ministers

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ministers.R
import ministers.databinding.FragmentMinistersBinding
import ministers.databinding.FragmentPartiesBinding


class MinistersFragment : Fragment() {
    private lateinit var binding: FragmentMinistersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMinistersBinding>(
            inflater, R.layout.fragment_ministers, container, false)
        val ministerData = ParliamentMembersData.members
        val party = ministerData.map { it.party}.toSet().sorted()
        binding.partyList.text = "$party"

        binding.showMinister.setOnClickListener {
            val j = binding.searchParty.text.toString()
            val imm = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.rootView?.windowToken, 0)
            val randomMp = ministerData.filter { it.party == j }.random()
            binding.showRand.text = randomMp.party
            binding.showRand.text = "Name :${randomMp.last} ${randomMp.first}"
        }

        binding.showRand.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER") {
                view:View -> view.findNavController().navigate(R.id.action_ministersFragment_to_ministerDetailsFragment2) }

        return binding.root
    }
}


