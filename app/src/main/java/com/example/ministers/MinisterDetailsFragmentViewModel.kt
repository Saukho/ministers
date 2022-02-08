package com.example.ministers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MinisterDetailsFragmentViewModel(party: String): ViewModel() {

    var currentMinister: MutableLiveData<String> = MutableLiveData()
    private set

    var index = 0
        private set
    val mps = ParliamentMembersData.members.filter { it.party == party }.toMutableList()
    var current = mps[ 0 ]
        private set

    fun updateMP() {
        index = (index + 1) % mps.size
        current = mps[ index ]
    }
}
