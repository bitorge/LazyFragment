package com.bitorge.lazyfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView

class TestFragment : LazyFragment() {
    val TAG = "TestFragment"
    var fragmentTag = ""

    companion object {
        fun newInstance(tag: String): TestFragment {
            val args = Bundle()
            args.putString("tag", tag)
            val fragment = TestFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentTag = requireArguments().getString("tag", fragmentTag)

        val tvTag = view.findViewById<AppCompatTextView>(R.id.tvTag)
        tvTag?.text = fragmentTag
    }

    override fun initExtras() {
        fragmentTag = requireArguments().getString("tag", fragmentTag)
        Log.e(TAG, "initExtras tag = $fragmentTag")
    }

    override fun lazyData() {
        Log.e(TAG, "lazyData tag = $fragmentTag")
    }

    override fun onLifecycleStart() {
        Log.e(TAG, "onLifecycleStart tag = $fragmentTag")
    }

    override fun onLifecycleStop() {
        Log.e(TAG, "onLifecycleStop tag = $fragmentTag")
    }

    override fun onLifecycleResume() {
        Log.e(TAG, "onLifecycleResume tag = $fragmentTag")
    }

    override fun onLifecyclePause() {
        Log.e(TAG, "onLifecyclePause tag = $fragmentTag")
    }
}