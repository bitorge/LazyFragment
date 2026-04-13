package com.bitorge.lazyfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class ViewPagerActivity : AppCompatActivity() {
    val fragmentList = mutableListOf(
        ViewpagerFragment(),
        TestFragment.newInstance("ViewPagerActivity_0"),
        TestFragment.newInstance("ViewPagerActivity_0"),
        TestFragment.newInstance("ViewPagerActivity_0"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)

        viewPager2.offscreenPageLimit = fragmentList.size
        viewPager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }
        }
    }
}