package com.example.exam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import java.util.Arrays.sort
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf<String>()

        val inputEditTxt = findViewById<EditText>(R.id.enterAnagramEditTxt)
        val countTxt = findViewById<TextView>(R.id.anagramCountTxt)
        val save = findViewById<Button>(R.id.saveBtn)
        val output = findViewById<Button>(R.id.outputBtn)
        var countInt = 0


        save.setOnClickListener {
            val input = inputEditTxt.text.toString()
            inputEditTxt.text.clear()
            list.add(input)
        }

        output.setOnClickListener {
            val input = inputEditTxt.text.toString()
            var i = 0
            var indicator = true
            for (s in list) {
                if(input.toCharArray().apply { sort() }
                        .contentEquals(s.toCharArray().apply { sort() })){
                    i++
                    if (i > 1)
                        indicator = false
                }
            }

            if (indicator) countInt++
            countTxt.text = "Anagrams count: $countInt"

        }
    }

}