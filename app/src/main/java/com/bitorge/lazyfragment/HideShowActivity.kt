package com.bitorge.lazyfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

class HideShowActivity : AppCompatActivity() {

    private val test0Fragment by lazy { TestFragment.newInstance("0") }
    private val test1Fragment by lazy { TestFragment.newInstance("1") }
    private val test2Fragment by lazy { TestFragment.newInstance("2") }
    private val test3Fragment by lazy { TestFragment.newInstance("3") }

    private var curFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide_show)

        val tv0 = findViewById<AppCompatTextView>(R.id.tv0)
        val tv1 = findViewById<AppCompatTextView>(R.id.tv1)
        val tv2 = findViewById<AppCompatTextView>(R.id.tv2)
        val tv3 = findViewById<AppCompatTextView>(R.id.tv3)

        showFragment(test0Fragment)
        tv0.isSelected = true

        tv0.setOnClickListener {
            curFragment = test0Fragment

            showFragment(test0Fragment)
            tv0.isSelected = true
            tv1.isSelected = false
            tv2.isSelected = false
            tv3.isSelected = false
        }

        tv1.setOnClickListener {
            curFragment = test1Fragment

            showFragment(test1Fragment)
            tv0.isSelected = false
            tv1.isSelected = true
            tv2.isSelected = false
            tv3.isSelected = false
        }

        tv2.setOnClickListener {
            curFragment = test2Fragment

            showFragment(test2Fragment)
            tv0.isSelected = false
            tv1.isSelected = false
            tv2.isSelected = true
            tv3.isSelected = false
        }

        tv3.setOnClickListener {
            curFragment = test3Fragment

            showFragment(test3Fragment)
            tv0.isSelected = false
            tv1.isSelected = false
            tv2.isSelected = false
            tv3.isSelected = true
        }
    }

    private fun showFragment(showFragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()

        if (!showFragment.isAdded) {
            ft.add(R.id.fragmentContainerView, showFragment)
        }

        ft.show(showFragment)
        //必须要调用此方法
        ft.setMaxLifecycle(showFragment, Lifecycle.State.RESUMED)

        if (showFragment != test0Fragment) {
            if (test0Fragment.isAdded){
                ft.hide(test0Fragment)
                //必须要调用此方法
                ft.setMaxLifecycle(test0Fragment, Lifecycle.State.STARTED)
            }
        }

        if (showFragment != test1Fragment) {
            if (test1Fragment.isAdded){
                ft.hide(test1Fragment)
                ft.setMaxLifecycle(test1Fragment, Lifecycle.State.STARTED)
            }
        }

        if (showFragment != test2Fragment) {
            if (test2Fragment.isAdded){
                ft.hide(test2Fragment)
                ft.setMaxLifecycle(test2Fragment, Lifecycle.State.STARTED)
            }
        }

        if (showFragment != test3Fragment) {
            if (test3Fragment.isAdded){
                ft.hide(test3Fragment)
                ft.setMaxLifecycle(test3Fragment, Lifecycle.State.STARTED)
            }
        }
        ft.commitAllowingStateLoss()
    }
}