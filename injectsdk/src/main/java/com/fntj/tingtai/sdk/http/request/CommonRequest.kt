package com.fntj.tingtai.sdk.http.request

import com.fntj.tingtai.utils.ObjectUtils
import okhttp3.FormBody
import okhttp3.Request

/**
 * @author 恒利
 * @function 接收请求参数,生成Request对象
 */
object CommonRequest {


    /**
     * @param url 请求路径
     * @param params 请求参数
     * @return Request 返回一个创建好的request对象
     * @function 创建一个Post请求
     */
    fun createPostRequest(url: String, params: RequestParams): Request {
        var mFormBodyBuild: FormBody.Builder = FormBody.Builder()
        if (ObjectUtils.isNotEmpty(params)) {
            for (entry in params.urlParams.entries) {
                //将请求参数遍历添加到请求构建类中
                mFormBodyBuild.add(entry.key, entry.value)
            }
        }
        //通过请求构建类的build方法获取到真正的请求体对象
        var mFormBody: FormBody = mFormBodyBuild.build()
        val build: Request = Request.Builder().url(url).post(mFormBody).build()
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