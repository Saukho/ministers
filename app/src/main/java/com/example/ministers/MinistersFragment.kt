package com.example.ministers

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ministers.R
import ministers.databinding.FragmentMinistersBinding

class MinistersFragment : Fragment() {
   private lateinit var binding: FragmentMinistersBinding
   private lateinit var viewModel: MinistersFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            viewModel = ViewModelProvider(this).get(MinistersFragmentViewModel::class.java)
            binding = DataBindingUtil.inflate<FragmentMinistersBinding>(
            inflater, R.layout.fragment_ministers, container, false)
            binding.partyList.text = viewModel.parties.sorted().joinToString(", ")
            binding.showMinister.setOnClickListener {
            val selectedParty = binding.searchParty.text.toString()
            if(selectedParty in viewModel.parties) {
                val action = MinistersFragmentDirections.actionMinisterFragmentToMinisterDetailsFragment(selectedParty)
                findNavController().navigate(action)
            } else {
                Toast.makeText(activity, "Hmh", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}
class MinistersFragmentViewModel :ViewModel(){
    val parties = ParliamentMembersData.members.map { it.party }.toSet()
}

