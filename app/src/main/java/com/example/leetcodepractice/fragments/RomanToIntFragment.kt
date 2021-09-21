package com.example.leetcodepractice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.leetcodepractice.R

class RomanToIntFragment : Fragment() {

    private lateinit var tv: TextView
    private lateinit var btn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_layout, container, false)

        tv = view.findViewById(R.id.fragment_tv)
        btn = view.findViewById<Button>(R.id.fragment_btn)
        tv.text = "Given a roman numeral, convert it to an integer."

        btn.setOnClickListener {
            romanToInt("MCMXCIV")
            Toast.makeText(activity, "MCMXCIV =" + romanToInt("MCMXCIV"), Toast.LENGTH_SHORT).show()
        }

        return view
    }

    fun romanToInt(s: String): Int {
        val list = s.split("").subList(1, s.length + 1)
        var sum = 0
        var result = 0
        var i = 0
        var t = ""

        while (i < list.size) {
            if (i + 1 < list.size)
                t = list.get(i + 1)
            else
                t = "End"
            result = countLetter(list.get(i), t)
            if (result == 4 || result == 40 || result == 400 ||
                result == 9 || result == 90 || result == 900
            )
                i++
            sum += result
            i++
        }
        return sum
    }

    fun countLetter(letter: String, nextLetter: String): Int {
        var sum = 0
        when (letter) {
            "V" -> sum += 5
            "L" -> sum += 50
            "D" -> sum += 500
            "M" -> sum += 1000
            "I" -> {
                when (nextLetter) {
                    "V" -> sum += 4
                    "X" -> sum += 9
                    else -> sum += 1
                }
            }
            "X" -> {
                when (nextLetter) {
                    "L" -> sum += 40
                    "C" -> sum += 90
                    else -> sum += 10
                }
            }
            "C" -> {
                when (nextLetter) {
                    "D" -> sum += 400
                    "M" -> sum += 900
                    else -> sum += 100
                }
            }
            else -> println("Incorrect")
        }
        return sum
    }
}