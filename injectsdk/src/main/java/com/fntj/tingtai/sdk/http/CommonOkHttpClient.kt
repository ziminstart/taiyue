package com.fntj.tingtai.sdk.http

import com.fntj.tingtai.sdk.http.https.HttpsUtils
import com.fntj.tingtai.sdk.http.response.CommonJsonCallback
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier


/**
 * @author 恒利
 * @function  请求的发送,请求参数的配置,https支持
 */
object CommonOkHttpClient {
    private const val TIME_OUT: Long = 30 // 超时参数
    var okHttpClient: OkHttpClient

    //为配置okHttp
    init {
        //创建client的构建者
        val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        //为构建者填充超时时间参数
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS)
        okHttpBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        //允许请求转发和重定向
        okHttpBuilder.followRedirects(true)
        //https支持
        okHttpBuilder.hostnameVerifier(HostnameVerifier { hostname, session -> true })
        okHttpBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(), HttpsUtils.initTrustManager());
        okHttpClient = okHttpBuilder.build()
    }

    /**
     * 发送具体的http/https请求
     * @param request
     * @param commCallback
     * @return Call实例
     */
    fun sendRequest(request: Request, commCallback: CommonJsonCallback): Call {
        val call: Call = okHttpClient.newCall(request)
        call.enqueue(commCallback)
        return call
    }

}