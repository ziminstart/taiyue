package com.fntj.tingtai.application

import android.app.Application

/**
 * @author 恒利
 * @function
 *  1是整个程序的入口
 *  2第三方框架的初始化工作
 *  3为整个应用的其它模块提供上下文
 */
class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private  var instance: AppApplication? = null
        fun instance() = instance
    }
}