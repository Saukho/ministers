package com.example.ministers

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter
import ministers.R
import ministers.databinding.FragmentMinistersBinding
import android.widget.ListAdapter as AndroidWidgetListAdapter

class MinistersFragmentViewModel:ViewModel() {
fun getMembers(): List<String> {
   var ministersParties = ParliamentMembersData.members.map { it.party}.toSet().sorted()
    return ministersParties
}
}
class MinistersFragment : Fragment() {

    lateinit var viewModel: MinistersFragmentViewModel

    var randomId = 0
    var randomMinister = String()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MinistersFragmentViewModel::class.java)

            val binding = DataBindingUtil.inflate<FragmentMinistersBinding>(
            inflater, R.layout.fragment_ministers, container, false)

            val ministerData = ParliamentMembersData.members
            val party = ministerData.map { it.party}.toSet().sorted()
            binding.partyList.text = "$party"

        binding.showMinister.setOnClickListener {
            val j = binding.searchParty.text.toString()
            val randomMp = ministerData.filter { it.party == j }.random()
            val randomParty = randomMp.party
            randomId = randomMp.personNumber
            print(randomId)
            randomMinister = "${randomMp.last} ${randomMp.first} ${randomMp.personNumber}"
            val imm = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.rootView?.windowToken, 0)
            binding.showRand.text = "$randomParty  \n $randomMinister \n $randomId"
        }

        binding.showRand.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER") {
                view:View -> view.findNavController().navigate(R.id.action_ministerFragment_to_ministerDetailsFragment)
            val action = MinistersFragmentDirections.actionMinisterFragmentToMinisterDetailsFragment(
            randomId,randomMinister
            )
            findNavController().navigate(action)
            println(action)

        }



        return binding.root
    }



}




