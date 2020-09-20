package com.fntj.tingtai.sdk.http.listener

import java.util.*

/**********************************************************
 * @文件名称：DisposeHandleCookieListener.java
 * @文件作者：renzhiqiang
 * @创建时间：2016年1月26日 下午10:17:53
 * @文件描述：当需要专门处理Cookie时创建此回调接口
 * @修改历史：2016年1月26日创建初始版本
 */
interface DisposeHandleCookieListener : DisposeDataListener {
    fun onCookie(cookieStrLists: ArrayList<String?>?)
}