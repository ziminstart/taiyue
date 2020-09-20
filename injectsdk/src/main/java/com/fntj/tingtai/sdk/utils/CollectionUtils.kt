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
package com.fntj.tingtai.sdk.utils

/**
 * Collection工具类
 *
 * @author Caratacus
 * @since 2016-09-19
 */
object CollectionUtils {
    /**
     * 校验集合是否为空
     *
     * @param coll 入参
     * @return boolean
     */
     fun isEmpty(coll: Collection<*>?): Boolean {
        return coll == null || coll.isEmpty()
    }

    /**
     * 校验集合是否不为空
     *
     * @param coll 入参
     * @return boolean
     */
    fun isNotEmpty(coll: Collection<*>?): Boolean {
        return !isEmpty(coll)
    }

    /**
     * 判断Map是否为空
     *
     * @param map 入参
     * @return boolean
     */
    fun isEmpty(map: Map<*, *>?): Boolean {
        return map == null || map.isEmpty()
    }

    /**
     * 判断Map是否不为空
     *
     * @param map 入参
     * @return boolean
     */
    fun isNotEmpty(map: Map<*, *>?): Boolean {
        return !isEmpty(map)
    }
}