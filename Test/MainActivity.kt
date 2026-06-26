package com.example.test

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tv = TextView(this)

        val unitTest = add(5, 3) == 8
        val integrationTest = getMessage() == "Hello"

        // Add padding: Left, Top, Right, Bottom
        tv.setPadding(30, 120, 30, 30)

        tv.text = """
            
            
            
            TESTING PYRAMID
            
            UI Test: TextView Displayed
            
            
            Integration Test: $integrationTest
            
            
            Unit Test: $unitTest
        """.trimIndent()

        tv.textSize = 20f

        setContentView(tv)
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }

    private fun getMessage(): String {
        return "Hello"
    }
}
