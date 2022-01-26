package com.example.tiistai25

import MemberOfParliament
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.tiistai25.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //private lateinit var btn: Button
    //private lateinit var txt: TextView
    private var on = false
    private lateinit var memberOfParliament:MemberOfParliament

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //binding.memberOfParliament
        //  btn = findViewById(R.id.button)
        //  txt  = findViewById(R.id.textView)
        binding.searchButton.setOnClickListener {
           updateUI(it)
        }
    }
    private fun updateUI(view:View) {
//        val findParties =findViewById<EditText>(R.id.findParties)
//        val fullName = findViewById<TextView>(R.id.full_name)

        binding.apply {
            findParties.text = findParties.text.toString()
            invalidateAll()
            fullName.visibility  = View.GONE
            findParties.visibility = View.GONE
            searchButton.visibility = View.VISIBLE
            //findParties.visibility = View.VISIBLE
            fullName.visibility  = View.VISIBLE
        }
        //binding.name.text = "${mp.first} ${mp.last} ($age)"
        //binding.findParties.text = mp.party.uppercase()
        val m = ParliamentMembersData.members
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
}
}
