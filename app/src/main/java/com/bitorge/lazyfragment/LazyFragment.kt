package com.bitorge.lazyfragment

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

open class LazyFragment : Fragment() {
    var isInitLazy = false
    var isOnLifecycleResume = false

    private val lifecycleEventObserver = LifecycleEventObserver { _, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                if (!isInitLazy) {
                    initExtras()
                    lazyData()
                    isInitLazy = true
                }
            }

            Lifecycle.Event.ON_START -> {
                onLifecycleStart()
            }

            Lifecycle.Event.ON_STOP -> {
                onLifecycleStop()
            }

            Lifecycle.Event.ON_RESUME -> {
                isOnLifecycleResume = true
                onLifecycleResume()
            }

            Lifecycle.Event.ON_PAUSE -> {
                isOnLifecycleResume = false
                onLifecyclePause()
            }

            else -> {

            }
        }
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        lifecycle.addObserver(lifecycleEventObserver)
    }

    override fun onDetach() {
        super.onDetach()
        lifecycle.removeObserver(lifecycleEventObserver)
    }

    open fun initExtras() {}
    open fun lazyData() {}

    open fun onLifecycleStart() {}

    open fun onLifecycleStop() {}

    open fun onLifecycleResume() {}

    open fun onLifecyclePause() {}
}