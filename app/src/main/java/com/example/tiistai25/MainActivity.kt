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
//    private fun getRandomMinisterByParty(parliament: MemberOfParliament){
//        val inputParty = binding.parties.editableText
//        if (inputParty.toString() == "ps"){
//            binding.minister.text = "persut tulee"
//        }
//    }
    private fun updateUI(view: View) {
        val p = ParliamentMembersData.members
        val id = p.map { it.seatNumber }
        val lastName = p.map { it.last }.toSet().sorted()
        val firstName = p.map { it.first }.toSet().sorted()
        val party = p.map { it.party }.toSet().sorted()
        val inputParty = binding.parties.editableText.toString()
        val mapParty =  p.map { inputParty }.toString()
        if(mapParty == inputParty){

        }

        binding.party.text = mapParty
        binding.minister.text = p.map { it.last }.toString()


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
}
}

