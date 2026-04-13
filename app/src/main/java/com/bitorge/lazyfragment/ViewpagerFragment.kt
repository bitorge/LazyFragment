package com.bitorge.lazyfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class ViewpagerFragment : LazyFragment() {
    val fragmentList = mutableListOf(
        TestFragment.newInstance("ViewpagerFragment_0"),
        TestFragment.newInstance("ViewpagerFragment_1"),
        TestFragment.newInstance("ViewpagerFragment_2"),
        TestFragment.newInstance("ViewpagerFragment_3"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_viewpager, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewpager2 = view.findViewById<ViewPager2>(R.id.viewPager2)
        viewpager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }
        }
    }
}