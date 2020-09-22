package com.fntj.tingtai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fntj.tingtai.R
import com.fntj.tingtai.socket.cilent.JWebSocketClient
import com.fntj.tingtai.view.fragment.base.BaseFragment
import org.java_websocket.handshake.ServerHandshake
import java.net.URI

/**
 * @author 恒利
 * @date 2020-09-20 12:51
 */
class ClassFragment : BaseFragment(), View.OnClickListener {

    private lateinit var mContextView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContext = activity
        mContextView = inflater.inflate(R.layout.fragment_class_layout, container, false)
//        initSocket()
        return mContextView
    }



    /**
     * 初始化java-websocket
     */
    private fun initSocket() {
        println("开始连接socket")
        val uri = URI.create("ws://192.168.0.38:9999")
        val client : JWebSocketClient = object : JWebSocketClient(uri){
            override fun onOpen(handshakedata: ServerHandshake?) {
                super.onOpen(handshakedata)
                print("连接成功")
            }

            override fun onMessage(message: String?) {
                super.onMessage(message)
                print("接收到消息")
            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                super.onClose(code, reason, remote)
                print("关闭")
            }

            override fun onError(ex: Exception?) {
                super.onError(ex)
                print("错误")
            }
        }
        client.connectBlocking()
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