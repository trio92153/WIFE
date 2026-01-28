package com.wife.app

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this)
        textView.text = "WIFE ❤️"
        textView.textSize = 26f
        textView.setTextColor(0xFFFFFFFF.toInt())
        textView.setBackgroundColor(0xFF000000.toInt())
        textView.gravity = android.view.Gravity.CENTER

        setContentView(textView)
    }
}
