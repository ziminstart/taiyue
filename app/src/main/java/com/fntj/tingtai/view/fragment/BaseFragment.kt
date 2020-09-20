package com.fntj.tingtai.view.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * @author 恒利
 * @function 为我们所有的fragment提供公共的行为或事件
 */
open class BaseFragment : Fragment() {
    protected open var mContext: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }
    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}