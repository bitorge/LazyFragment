package com.bitorge.lazyfragment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<AppCompatButton>(R.id.btnHideShow).setOnClickListener {
            startActivity(Intent(this@MainActivity, HideShowActivity::class.java))
        }

        findViewById<AppCompatButton>(R.id.btnViewPager).setOnClickListener {
            startActivity(Intent(this@MainActivity, ViewPagerActivity::class.java))
        }

        findViewById<AppCompatButton>(R.id.btnNav).setOnClickListener {
            startActivity(Intent(this@MainActivity, NavActivity::class.java))
        }
    }
}