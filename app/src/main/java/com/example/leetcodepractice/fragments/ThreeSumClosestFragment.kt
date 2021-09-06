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

class ThreeSumClosestFragment : Fragment() {

    private lateinit var tv: TextView
    private lateinit var btn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_layout, container, false)

        tv = view.findViewById(R.id.fragment_tv)
        btn = view.findViewById<Button>(R.id.fragment_btn)
        tv.text =
            "Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.\n" +
                    "\n" +
                    "Return the sum of the three integers.\n" +
                    "\n" +
                    "You may assume that each input would have exactly one solution."

        btn.setOnClickListener {
            val array = intArrayOf(-1, 2, 1, -4)
            val result = threeSumClosest(array, 1)
            Toast.makeText(activity, result.toString(), Toast.LENGTH_SHORT).show()
        }

        return view
    }

    private fun threeSumClosest(nums: IntArray, target: Int): Int {
        var closestSum = nums[0] + nums[1] + nums[2]
        val size = nums.size
        for (i in 2 until size) {
            for (j in 1 until i) {
                for (k in 0 until j) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(closestSum - target)) {
                        closestSum = nums[i] + nums[j] + nums[k]
                    }
                }
            }
        }
        return closestSum
    }
}