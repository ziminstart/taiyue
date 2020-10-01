package com.fntj.tingtai.sdk.http.request

import com.alibaba.fastjson.JSON
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody


/**
 * @author 恒利
 * @function 接收请求参数,生成Request对象
 */
object CommonRequest {

    private val json: MediaType = "application/json;charset=utf-8".toMediaType()

    /**
     * @param url 请求路径
     * @param params 请求参数
     * @return Request 返回一个创建好的request对象
     * @function 创建一个Post请求
    t*/
    fun createPostRequest(url: String, params: HashMap<String, String>): Request {
        val param = JSON.toJSONString(params).toRequestBody(json)
        val build: Request = Request.Builder().url(url).post(param).build()
        return build
    }

    /**
     * @param url 请求路径
     * @param params 请求参数
     * @return Request 返回一个创建好的request对象
     * @function 创建一个Post请求
     */
    fun createGetRequest(url: String, vararg args: Any?): Request {
        val url = String.format(url, args)
        return Request.Builder().url(url).get().build()
    }

}