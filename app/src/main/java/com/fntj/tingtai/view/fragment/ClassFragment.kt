package com.fntj.tingtai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fntj.tingtai.R

/**
 * @author 恒利
 * @date 2020-09-20 12:51
 */
class ClassFragment : BaseFragment(), View.OnClickListener {

    private lateinit var mContextView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContext = activity
        mContextView = inflater.inflate(R.layout.fragment_class_layout, container, false)
        return mContextView
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

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}