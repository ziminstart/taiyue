package com.fntj.tingtai.view.activity

import android.os.Bundle
import android.view.View
import com.fntj.tingtai.R
import com.fntj.tingtai.view.activity.base.BaseActivity

/**
 * @author 恒利
 * @date 2020-10-04 09:46
 * @function 聊天界面
 */
class ChatActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_layout)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}