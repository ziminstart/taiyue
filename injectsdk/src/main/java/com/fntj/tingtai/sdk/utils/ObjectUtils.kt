/*
 * Copyright (c) 2011-2020, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.fntj.tingtai.utils

import java.lang.reflect.Array

/**
 * 对象工具类
 *
 * @author hubin
 * @since 2018-06-05
 */
object ObjectUtils {
    /**
     * 判断object是否为空,集合会校验size
     */
    fun isNull(vararg objs: Any?): Boolean {
        for (obj in objs) {
            if (isEmpty(obj)) {
                return true
            }
        }
        return false
    }

    /**
     * 判断object是否不为空,集合会校验size
     */
    fun isNotNull(vararg obj: Any?): Boolean {
        return !isNull(*obj)
    }

    /**
     * 对象非空判断
     */
    fun isNotEmpty(obj: Any?): Boolean {
        return !isEmpty(obj)
    }

    /**
     * 对象空判断
     */
    fun isEmpty(obj: Any?): Boolean {
        if (obj == null) {
            return true
        }
        if (obj.javaClass.isArray) {
            return Array.getLength(obj) == 0
        }
        if (obj is CharSequence) {
            return obj.length == 0
        }
        if (obj is Collection<*>) {
            return obj.isEmpty()
        }
        return if (obj is Map<*, *>) {
            obj.isEmpty()
        } else false
        // else
    }
}