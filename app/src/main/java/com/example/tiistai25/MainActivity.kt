package com.example.tiistai25

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.tiistai25.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val ministerData = ParliamentMembersData.members
        val party = ministerData.map { it.party }.toSet().sorted()
//        val lastName = ministerData.map { it.last }.toSet().sorted()
        ministerData.joinToString(" ,")
        println(party)
        binding.party.text = "$party"
        binding.searchButton.setOnClickListener {
           updateUI(it)
        }
    }

    private fun updateUI(view: View) {
        val p = ParliamentMembersData.members
        val inputParty = binding.parties.editableText.toString()
        val randomMp =  p.filter{ it.party == inputParty }.random()

        binding.party.text = randomMp.party
        binding.minister.text = "Name :${randomMp.last} ${randomMp.first}"


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
}
}

