package com.example.leetcodepractice.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.leetcodepractice.R
import java.util.*

class AddTwoNumbersFragment : Fragment() {

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
            "You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.\n" +
                    "\n" +
                    "You may assume the two numbers do not contain any leading zero, except the number 0 itself."

        val firstDigit1 = ListNode(9)
        val secondDigit1 = ListNode(9)
        firstDigit1.next = secondDigit1
        val thirdDigit1 = ListNode(9)
        secondDigit1.next = thirdDigit1

        val firstDigit2 = ListNode(9)
        val secondDigit2 = ListNode(9)
        firstDigit2.next = secondDigit2
        val thirdDigit2 = ListNode(9)
        secondDigit2.next = thirdDigit2

        val s = listNodeToString(addTwoNumbers(firstDigit1, firstDigit2))
        btn.setOnClickListener {
            Toast.makeText(
                activity,
                s,
                Toast.LENGTH_LONG
            ).show()
        }

        return view
    }

    fun listNodeToString(l: ListNode): String {
        var s = "[${l.value}"
        var ln = l.next
        while (ln != null) {
            s = "$s, ${ln.value}"
            ln = ln.next
        }
        return "$s]"
    }

    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        var size1 = 1
        var lN = l1.next
        while(lN!=null){
            lN = lN.next
            size1++
        }

        var size2 = 1
        lN = l2.next
        while(lN!=null){
            lN = lN.next
            size2++
        }

        var biggerSize = size1
        if(size2 > size1)
            biggerSize = size2

        //1 digit
        var temp = l1.value + l2.value
        var result =  ListNode(temp % 10)

        var nextL1:ListNode? = l1.next
        if(nextL1 == null)
            nextL1 = ListNode(0)

        var nextL2:ListNode? = l2.next
        if(nextL2 == null)
            nextL2 = ListNode(0)

        //2 digit
        temp = temp / 10 + nextL1.value + nextL2.value
        var next:ListNode? = ListNode(temp % 10)
        if(biggerSize != 1 || temp != 0)
            result.next = next

        for(i in 3..biggerSize){

            nextL1 = nextL1?.next
            if(nextL1 == null)
                nextL1 = ListNode(0)

            nextL2 = nextL2?.next
            if(nextL2 == null)
                nextL2 = ListNode(0)

            temp = temp / 10 + nextL1.value + nextL2.value
            if(i != biggerSize || temp != 0)
                next?.next = ListNode(temp % 10)
            next = next?.next
        }

        if (temp >= 10)
            next?.next = ListNode(temp / 10)

        return result
    }
}