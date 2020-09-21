package com.fntj.tingtai.socket.cilent

import android.util.Log
import org.java_websocket.client.WebSocketClient
import org.java_websocket.drafts.Draft_6455
import org.java_websocket.handshake.ServerHandshake
import java.net.URI


/**
 * @author 恒利
 * @function 自定义一个客户端
 * Draft_6455 协议版本,可以不写
 */
open class JWebSocketClient(serverUri: URI?) : WebSocketClient(serverUri, Draft_6455()) {
    /**
     * websocket 连接开启时调用
     */
    override fun onOpen(handshakedata: ServerHandshake?) {
        Log.e("JWebSocketClient", "onOpen()")
    }

    /**
     * 接收到消息时调用
     */
    override fun onMessage(message: String?) {
        Log.e("JWebSocketClient", "onMessage()")
    }

    /**
     * 连接时调用
     */
    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        Log.e("JWebSocketClient", "onClose()")
    }

    /**
     * 错误回调
     */
    override fun onError(ex: Exception?) {
        Log.e("JWebSocketClient", "onError()")
    }
}