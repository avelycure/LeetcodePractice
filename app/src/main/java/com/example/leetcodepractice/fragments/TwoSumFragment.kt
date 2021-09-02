package com.example.leetcodepractice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.leetcodepractice.R
import java.util.*


class TwoSumFragment : Fragment() {

    private lateinit var tv: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_layout, container, false)
        tv = view.findViewById(R.id.fragment_tv)
        btn = view.findViewById<Button>(R.id.fragment_btn)
        tv.text =
            "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n" +
                    "\n" +
                    "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n" +
                    "\n" +
                    "You can return the answer in any order.\n" +
                    "\n"

        val array = intArrayOf(2, 7, 11, 15)
        val target = 9

        btn.setOnClickListener {
            Toast.makeText(
                activity,
                "array: ${Arrays.toString(array)}, target: $target, result: ${
                    Arrays.toString(
                        twoSum(
                            array,
                            target
                        )
                    )
                }",
                Toast.LENGTH_LONG
            ).show()
        }
        return view
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums.get(i) + nums.get(j) == target)
                    return intArrayOf(i, j)
            }
        }
        return intArrayOf(0)
    }
}