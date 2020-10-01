package com.fntj.tingtai.view.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author 恒利
 * @function 是为我们所有的activity 提供公共的行为
 */
open class BaseActivity : AppCompatActivity() {

    var tag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

}