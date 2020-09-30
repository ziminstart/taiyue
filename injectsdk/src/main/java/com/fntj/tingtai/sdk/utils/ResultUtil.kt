package com.fntj.tingtai.sdk.utils

import java.util.*

/**
 * 返回结果工具类
 *
 * @author s.li
 * @create 2018-02-06 14:38
 */
object ResultUtil {
    fun SUCCESS(): Map<String, Any?> {
        val resultMap: MutableMap<String, Any?> =
            HashMap()
        resultMap["success"] = true
        resultMap["message"] = "操作成功"
        resultMap["entity"] = null
        return resultMap
    }

    fun SUCCESS(dataObj: Any): Map<String, Any> {
        val resultMap: MutableMap<String, Any> =
            HashMap()
        resultMap["success"] = true
        resultMap["message"] = "操作成功"
        resultMap["entity"] = dataObj
        return resultMap
    }

    fun SUCCESS(message: String?): Map<String, Any?> {
        val resultMap: MutableMap<String, Any?> =
            HashMap()
        resultMap["success"] = true
        resultMap["message"] = message
        resultMap["entity"] = null
        return resultMap
    }

    fun SUCCESS(message: String, dataObj: Any): Map<String, Any> {
        val resultMap: MutableMap<String, Any> =
            HashMap()
        resultMap["success"] = true
        resultMap["message"] = message
        resultMap["entity"] = dataObj
        return resultMap
    }

    fun ERROR(): Map<String, Any?> {
        val resultMap: MutableMap<String, Any?> =
            HashMap()
        resultMap["success"] = false
        resultMap["message"] = "系统错误，操作失败"
        resultMap["entity"] = null
        return resultMap
    }

    fun ERROR(message: String, entity: Any): Map<String, Any> {
        val resultMap: MutableMap<String, Any> =
            HashMap()
        resultMap["success"] = false
        resultMap["message"] = message
        resultMap["entity"] = entity
        return resultMap
    }

    fun ERROR(message: String?): Map<String, Any?> {
        val resultMap: MutableMap<String, Any?> =
            HashMap()
        resultMap["success"] = false
        resultMap["message"] = message
        resultMap["entity"] = null
        return resultMap
    }

    fun to(
        resultMap: MutableMap<String?, Any?>,
        success: Boolean,
        message: String?,
        entity: Any?
    ): Map<String?, Any?> {
        resultMap["message"] = message
        resultMap["entity"] = entity
        resultMap["success"] = success
        return resultMap
    }

    fun to(
        resultMap: MutableMap<String?, Any?>,
        message: String?,
        entity: Any?
    ): Map<String?, Any?> {
        resultMap["message"] = message
        resultMap["entity"] = entity
        return resultMap
    }

    fun to(
        resultMap: MutableMap<String?, Any?>,
        entity: Any?
    ): Map<String?, Any?> {
        resultMap["entity"] = entity
        return resultMap
    }

    fun setEntity(
        resultMap: MutableMap<String?, Any?>,
        entity: Any?
    ) {
        resultMap["entity"] = entity
    }

    fun setSuccess(
        resultMap: MutableMap<String?, Any?>,
        success: Boolean
    ) {
        resultMap["success"] = success
    }

    fun setMessage(
        resultMap: MutableMap<String?, Any?>,
        message: String?
    ) {
        resultMap["message"] = message
    }
}