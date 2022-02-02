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
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
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
        val party = ministerData.map { it.party }.toSet().sorted()
        ministerData.joinToString(" ,")
        println(party)
        binding.partyList.text = "$party"
        return binding.root
        updateUI()

        val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.rootView?.windowToken, 0)

    }
    private fun updateUI() {
        val md = ParliamentMembersData.members
        binding.partyList.text = "$md"
        val inputParty = binding.searchParty.editableText.toString()
        val randomMp = md.filter { it.party == inputParty }.random()
        binding.showRand.text = randomMp.party
        binding.showRand.text = "Name :${randomMp.last} ${randomMp.first}"

    }

}


