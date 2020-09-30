package com.fntj.tingtai.api

/**
 * @author 恒利
 * @date 2020-09-23 20:22
 * @function 基本API,从后台获取数据
 */
object BaseApi {

    //本地环境
    val BASE_HOST: String = "192.168.0.25"
    private val BASE_URL: String = "http://192.168.0.25:3333/"

    /**
     * 首页
     * dataKey
     * userId
     * mobile
     */
    var HOME_DATA: String = BASE_URL + "index"



}