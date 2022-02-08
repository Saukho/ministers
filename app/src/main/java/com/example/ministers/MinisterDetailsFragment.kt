package com.example.ministers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ministers.databinding.FragmentMinisterDetailsBinding
import ministers.R


class MinisterDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMinisterDetailsBinding
    private lateinit var viewModel: MinisterDetailsFragmentViewModel
    private lateinit var viewModelFactory: MinisterDetailsFragmentViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = MinisterDetailsFragmentArgs.fromBundle(requireArguments())

        viewModelFactory = MinisterDetailsFragmentViewModelFactory(args.selectedParty)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MinisterDetailsFragmentViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_minister_details, container, false)


        updateUI()
//        viewModel.currentMinister.observe(viewLifecycleOwner) {
//            binding.nameView.text = it.toString()
//        }

        binding.nextButton.setOnClickListener {
            viewModel.updateMP()
            updateUI()
//            viewModel.currentMinister.observe(viewLifecycleOwner) {
//                binding.nameView.text = it.toString()
//            }
        }
        return binding.root
    }
    fun updateUI() {
        binding.nextButton.text = "${viewModel.index+1} / ${viewModel.mps.size}"
        binding.nameView.text = "${viewModel.current.first} ${viewModel.current.last}"
        binding.constituencyView.text = viewModel.current.constituency
        binding.ageView.text = "${viewModel.current.bornYear}"
        binding.ministerView.text = if (viewModel.current.minister) "ministeri" else "kansanedustaja"
    }
}


class MinisterDetailsFragmentViewModelFactory(private val party: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MinisterDetailsFragmentViewModel::class.java)) {
            return MinisterDetailsFragmentViewModel(party) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}