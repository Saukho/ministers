package com.example.ministers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ministers.R
import ministers.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Timber.i("onCreate called")

    }
    override fun onStart() {
        super.onStart()

        Timber.i("onStart Called")
    }
    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }


    //        val ministerData = ParliamentMembersData.members
//        val party = ministerData.map { it.party }.toSet().sorted()
//        ministerData.joinToString(" ,")
//        println(party)
//        binding.party.text = "$party"
//        binding.searchButton.setOnClickListener {
//           updateUI(it)
//        }


//    private fun updateUI(view: View) {
//        val p = ParliamentMembersData.members
//        val inputParty = binding.parties.editableText.toString()
//        val randomMp =  p.filter{ it.party == inputParty }.random()
//
//        binding.party.text = randomMp.party
//        binding.minister.text = "Name :${randomMp.last} ${randomMp.first}"
//
//
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view.windowToken, 0)
//}
}

