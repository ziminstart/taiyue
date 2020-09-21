package com.fntj.tingtai.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.fntj.tingtai.R
import com.fntj.tingtai.activity.base.BaseActivity
import com.fntj.tingtai.socket.cilent.JWebSocketClient
import com.fntj.tingtai.view.fragment.ClassFragment
import java.net.URI


/**
 * 创建首页所有的fragment
 */
class HomeActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    /**
     * 初始化视图
     */
    private fun initView() {
        var classFragment = ClassFragment()
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        ft.add(R.id.main_content_fragment_layout, classFragment)
        ft.commit();
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}