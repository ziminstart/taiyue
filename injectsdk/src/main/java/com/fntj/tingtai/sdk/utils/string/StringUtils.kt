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

import java.util.*
import java.util.regex.Pattern

/**
 * String 工具类
 *
 * @author D.Yang
 * @author hcl
 * @since 2016-08-18
 */
object StringUtils {
    /**
     * 空字符
     */
    const val EMPTY = StringPool.EMPTY

    /**
     * 字符串 is
     */
    const val IS = "is"

    /**
     * 下划线字符
     */
    const val UNDERLINE = '_'


    /**
     * 验证字符串是否是数据库字段
     */
    private val P_IS_COLUMN = Pattern.compile("^\\w\\S*[\\w\\d]*$")

    /**
     * 是否为大写命名
     */
    private val CAPITAL_MODE = Pattern.compile("^[0-9A-Z/_]+$")

    /**
     * 安全的进行字符串 format
     *
     * @param target 目标字符串
     * @param params format 参数
     * @return format 后的
     */
    fun format(target: String?, vararg params: Any?): String {
        return String.format(target!!, *params)
    }

    /**
     * 判断字符串是否为空
     *
     * @param cs 需要判断字符串
     * @return 判断结果
     */
    @Deprecated("")
    fun isEmpty(cs: CharSequence?): Boolean {
        return isBlank(cs)
    }

    fun isBlank(cs: CharSequence?): Boolean {
        if (cs == null) {
            return true
        }
        val l = cs.length
        if (l > 0) {
            for (i in 0 until l) {
                if (!Character.isWhitespace(cs[i])) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * 判断字符串是否不为空
     *
     * @param cs 需要判断字符串
     * @return 判断结果
     */
    @Deprecated("")
    fun isNotEmpty(cs: CharSequence?): Boolean {
        return !isEmpty(cs)
    }

    fun isNotBlank(cs: CharSequence?): Boolean {
        return !isBlank(cs)
    }

    /**
     * 猜测方法属性对应的 Getter 名称，具体规则请参考 JavaBeans 规范
     *
     * @param name 属性名称
     * @param type 属性类型
     * @return 返回猜测的名称
     */
    @Deprecated("3.3.2")
    fun guessGetterName(name: String, type: Class<*>): String {
        return if (Boolean::class.javaPrimitiveType == type) if (name.startsWith("is")) name else "is" + upperFirst(
            name
        ) else "get" + upperFirst(name)
    }

    /**
     * 大写第一个字母
     *
     * @param src 源字符串
     * @return 返回第一个大写后的字符串
     */
    fun upperFirst(src: String): String {
        return if (Character.isLowerCase(src[0])) {
            if (1 == src.length) src.toUpperCase() else Character.toUpperCase(src[0])
                .toString() + src.substring(1)
        } else src
    }

    /**
     * 判断字符串是否符合数据库字段的命名
     *
     * @param str 字符串
     * @return 判断结果
     */
    fun isNotColumnName(str: String?): Boolean {
        return !P_IS_COLUMN.matcher(str).matches()
    }

    /**
     * 获取真正的字段名
     *
     * @param column 字段名
     * @return 字段名
     */
    fun getTargetColumn(column: String): String {
        return if (isNotColumnName(column)) {
            column.substring(1, column.length - 1)
        } else column
    }

    /**
     * 字符串驼峰转下划线格式
     *
     * @param param 需要转换的字符串
     * @return 转换好的字符串
     */
    fun camelToUnderline(param: String): String {
        if (isBlank(param)) {
            return EMPTY
        }
        val len = param.length
        val sb = StringBuilder(len)
        for (i in 0 until len) {
            val c = param[i]
            if (Character.isUpperCase(c) && i > 0) {
                sb.append(UNDERLINE)
            }
            sb.append(Character.toLowerCase(c))
        }
        return sb.toString()
    }

    /**
     * 解析 getMethodName -> propertyName
     *
     * @param getMethodName 需要解析的
     * @return 返回解析后的字段名称
     */
    fun resolveFieldName(getMethodName: String): String {
        var getMethodName = getMethodName
        if (getMethodName.startsWith("get")) {
            getMethodName = getMethodName.substring(3)
        } else if (getMethodName.startsWith(IS)) {
            getMethodName = getMethodName.substring(2)
        }
        // 小写第一个字母
        return firstToLowerCase(getMethodName)
    }

    /**
     * 字符串下划线转驼峰格式
     *
     * @param param 需要转换的字符串
     * @return 转换好的字符串
     */
    fun underlineToCamel(param: String): String {
        if (isBlank(param)) {
            return EMPTY
        }
        val temp = param.toLowerCase()
        val len = temp.length
        val sb = StringBuilder(len)
        var i = 0
        while (i < len) {
            val c = temp[i]
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(temp[i]))
                }
            } else {
                sb.append(c)
            }
            i++
        }
        return sb.toString()
    }

    /**
     * 首字母转换小写
     *
     * @param param 需要转换的字符串
     * @return 转换好的字符串
     */
    fun firstToLowerCase(param: String): String {
        return if (isBlank(param)) {
            EMPTY
        } else param.substring(0, 1).toLowerCase() + param.substring(1)
    }

    /**
     * 判断字符串是否为纯大写字母
     *
     * @param str 要匹配的字符串
     * @return
     */
    fun isUpperCase(str: String?): Boolean {
        return matches("^[A-Z]+$", str)
    }

    /**
     * 正则表达式匹配
     *
     * @param regex 正则表达式字符串
     * @param input 要匹配的字符串
     * @return 如果 input 符合 regex 正则表达式格式, 返回true, 否则返回 false;
     */
    fun matches(regex: String?, input: String?): Boolean {
        return if (null == regex || null == input) {
            false
        } else Pattern.matches(regex, input)
    }

    /**
     * 判断对象是否不为空
     *
     * @param object ignore
     * @return ignore
     */
    fun checkValNotNull(`object`: Any?): Boolean {
        return if (`object` is CharSequence) {
            isNotBlank(`object` as CharSequence?)
        } else `object` != null
    }

    /**
     * 判断对象是否为空
     *
     * @param object ignore
     * @return ignore
     */
    fun checkValNull(`object`: Any?): Boolean {
        return !checkValNotNull(`object`)
    }

    /**
     * 包含大写字母
     *
     * @param word 待判断字符串
     * @return ignore
     */
    fun containsUpperCase(word: String): Boolean {
        for (i in 0 until word.length) {
            val c = word[i]
            if (Character.isUpperCase(c)) {
                return true
            }
        }
        return false
    }

    /**
     * 是否为大写命名
     *
     * @param word 待判断字符串
     * @return ignore
     */
    fun isCapitalMode(word: String?): Boolean {
        return null != word && CAPITAL_MODE.matcher(word).matches()
    }

    /**
     * 是否为驼峰下划线混合命名
     *
     * @param word 待判断字符串
     * @return ignore
     */
    fun isMixedMode(word: String?): Boolean {
        return matches(
            ".*[A-Z]+.*",
            word
        ) && matches(".*[/_]+.*", word)
    }

    /**
     * 判断是否以某个字符串结尾（区分大小写）
     * Check if a String ends with a specified suffix.
     *
     *
     * `null`s are handled without exceptions. Two `null`
     * references are considered to be equal. The comparison is case sensitive.
     *
     *
     *
     * <pre>
     * StringUtils.endsWith(null, null)      = true
     * StringUtils.endsWith(null, "abcdef")  = false
     * StringUtils.endsWith("def", null)     = false
     * StringUtils.endsWith("def", "abcdef") = true
     * StringUtils.endsWith("def", "ABCDEF") = false
    </pre> *
     *
     *
     * @param str    the String to check, may be null
     * @param suffix the suffix to find, may be null
     * @return `true` if the String ends with the suffix, case
     * sensitive, or both `null`
     * @see String.endsWith
     * @since 2.4
     */
    fun endsWith(str: String?, suffix: String?): Boolean {
        return endsWith(str, suffix, false)
    }

    /**
     * 判断是否以某个字符串结尾（不区分大小写）
     * Case insensitive check if a String ends with a specified suffix.
     *
     *
     * `null`s are handled without exceptions. Two `null`
     * references are considered to be equal. The comparison is case
     * insensitive.
     *
     *
     *
     * <pre>
     * StringUtils.endsWithIgnoreCase(null, null)      = true
     * StringUtils.endsWithIgnoreCase(null, "abcdef")  = false
     * StringUtils.endsWithIgnoreCase("def", null)     = false
     * StringUtils.endsWithIgnoreCase("def", "abcdef") = true
     * StringUtils.endsWithIgnoreCase("def", "ABCDEF") = false
    </pre> *
     *
     *
     * @param str    the String to check, may be null
     * @param suffix the suffix to find, may be null
     * @return `true` if the String ends with the suffix, case
     * insensitive, or both `null`
     * @see String.endsWith
     * @since 2.4
     */
    fun endsWithIgnoreCase(str: String?, suffix: String?): Boolean {
        return endsWith(str, suffix, true)
    }

    /**
     * Check if a String ends with a specified suffix (optionally case
     * insensitive).
     *
     * @param str        the String to check, may be null
     * @param suffix     the suffix to find, may be null
     * @param ignoreCase inidicates whether the compare should ignore case (case
     * insensitive) or not.
     * @return `true` if the String starts with the prefix or both
     * `null`
     * @see String.endsWith
     */
    private fun endsWith(str: String?, suffix: String?, ignoreCase: Boolean): Boolean {
        if (str == null || suffix == null) {
            return str == null && suffix == null
        }
        if (suffix.length > str.length) {
            return false
        }
        val strOffset = str.length - suffix.length
        return str.regionMatches(strOffset, suffix, 0, suffix.length, ignoreCase = ignoreCase)
    }

    /**
     * Splits the provided text into an array, separators specified. This is an
     * alternative to using StringTokenizer.
     *
     *
     * The separator is not included in the returned String array. Adjacent
     * separators are treated as one separator. For more control over the split
     * use the StrTokenizer class.
     *
     *
     *
     * A `null` input String returns `null`. A `null`
     * separatorChars splits on whitespace.
     *
     *
     *
     * <pre>
     * StringUtils.split(null, *)         = null
     * StringUtils.split("", *)           = []
     * StringUtils.split("abc def", null) = ["abc", "def"]
     * StringUtils.split("abc def", " ")  = ["abc", "def"]
     * StringUtils.split("abc  def", " ") = ["abc", "def"]
     * StringUtils.split("ab:cd:ef", ":") = ["ab", "cd", "ef"]
    </pre> *
     *
     *
     * @param str            the String to parse, may be null
     * @param separatorChars the characters used as the delimiters, `null` splits on
     * whitespace
     * @return an array of parsed Strings, `null` if null String input
     */
    fun split(str: String?, separatorChars: String?): Array<String> {
        val strings =
            splitWorker(str, separatorChars, -1, false)
        return strings!!.toTypedArray()
    }

    /**
     * Performs the logic for the `split` and
     * `splitPreserveAllTokens` methods that return a maximum array
     * length.
     *
     * @param str               the String to parse, may be `null`
     * @param separatorChars    the separate character
     * @param max               the maximum number of elements to include in the array. A zero
     * or negative value implies no limit.
     * @param preserveAllTokens if `true`, adjacent separators are treated as empty
     * token separators; if `false`, adjacent separators are
     * treated as one separator.
     * @return an array of parsed Strings, `null` if null String input
     */
    fun splitWorker(
        str: String?, separatorChars: String?, max: Int,
        preserveAllTokens: Boolean
    ): List<String>? {
        // Performance tuned for 2.0 (JDK1.4)
        // Direct code is quicker than StringTokenizer.
        // Also, StringTokenizer uses isSpace() not isWhitespace()
        if (str == null) {
            return null
        }
        val len = str.length
        if (len == 0) {
            return emptyList()
        }
        val list: MutableList<String> = ArrayList()
        var sizePlus1 = 1
        var i = 0
        var start = 0
        var match = false
        var lastMatch = false
        if (separatorChars == null) {
            // Null separator means use whitespace
            while (i < len) {
                if (Character.isWhitespace(str[i])) {
                    if (match || preserveAllTokens) {
                        lastMatch = true
                        if (sizePlus1++ == max) {
                            i = len
                            lastMatch = false
                        }
                        list.add(str.substring(start, i))
                        match = false
                    }
                    start = ++i
                    continue
                }
                lastMatch = false
                match = true
                i++
            }
        } else if (separatorChars.length == 1) {
            // Optimise 1 character case
            val sep = separatorChars[0]
            while (i < len) {
                if (str[i] == sep) {
                    if (match || preserveAllTokens) {
                        lastMatch = true
                        if (sizePlus1++ == max) {
                            i = len
                            lastMatch = false
                        }
                        list.add(str.substring(start, i))
                        match = false
                    }
                    start = ++i
                    continue
                }
                lastMatch = false
                match = true
                i++
            }
        } else {
            // standard case
            while (i < len) {
                if (separatorChars.indexOf(str[i]) >= 0) {
                    if (match || preserveAllTokens) {
                        lastMatch = true
                        if (sizePlus1++ == max) {
                            i = len
                            lastMatch = false
                        }
                        list.add(str.substring(start, i))
                        match = false
                    }
                    start = ++i
                    continue
                }
                lastMatch = false
                match = true
                i++
            }
        }
        if (match || preserveAllTokens && lastMatch) {
            list.add(str.substring(start, i))
        }
        return list
    }

    /**
     * 是否为CharSequence类型
     *
     * @param clazz class
     * @return true 为是 CharSequence 类型
     */
    fun isCharSequence(clazz: Class<*>?): Boolean {
        return clazz != null && CharSequence::class.java.isAssignableFrom(clazz)
    }

    /**
     * 第一个首字母小写，之后字符大小写的不变
     *
     * StringUtils.firstCharToLower( "UserService" )     = userService
     *
     * StringUtils.firstCharToLower( "UserServiceImpl" ) = userServiceImpl
     *
     * @param rawString 需要处理的字符串
     * @return ignore
     */
    fun firstCharToLower(rawString: String): String {
        return prefixToLower(rawString, 1)
    }

    /**
     * 前n个首字母小写,之后字符大小写的不变
     *
     * @param rawString 需要处理的字符串
     * @param index     多少个字符(从左至右)
     * @return ignore
     */
    fun prefixToLower(rawString: String, index: Int): String {
        val beforeChar = rawString.substring(0, index).toLowerCase()
        val afterChar = rawString.substring(index)
        return beforeChar + afterChar
    }

    /**
     * 删除字符前缀之后,首字母小写,之后字符大小写的不变
     *
     * StringUtils.removePrefixAfterPrefixToLower( "isUser", 2 )     = user
     *
     * StringUtils.removePrefixAfterPrefixToLower( "isUserInfo", 2 ) = userInfo
     *
     * @param rawString 需要处理的字符串
     * @param index     删除多少个字符(从左至右)
     * @return ignore
     */
    fun removePrefixAfterPrefixToLower(rawString: String, index: Int): String {
        return prefixToLower(rawString.substring(index), 1)
    }

    /**
     * 驼峰转连字符
     *
     * StringUtils.camelToHyphen( "managerAdminUserService" ) = manager-admin-user-service
     *
     * @param input ignore
     * @return 以'-'分隔
     * @see [document](https://github.com/krasa/StringManipulation)
     */
    fun camelToHyphen(input: String): String {
        return wordsToHyphenCase(
            wordsAndHyphenAndCamelToConstantCase(
                input
            )
        )
    }

    private fun wordsAndHyphenAndCamelToConstantCase(input: String): String {
        val betweenUpperCases = false
        val containsLowerCase = containsLowerCase(input)
        val buf = StringBuilder()
        var previousChar = ' '
        val chars = input.toCharArray()
        for (c in chars) {
            val isUpperCaseAndPreviousIsUpperCase =
                Character.isUpperCase(previousChar) && Character.isUpperCase(c)
            val isUpperCaseAndPreviousIsLowerCase =
                Character.isLowerCase(previousChar) && Character.isUpperCase(c)
            val previousIsWhitespace = Character.isWhitespace(previousChar)
            val lastOneIsNotUnderscore = buf.length > 0 && buf[buf.length - 1] != '_'
            val isNotUnderscore = c != '_'
            if (lastOneIsNotUnderscore && (isUpperCaseAndPreviousIsLowerCase || previousIsWhitespace
                        || betweenUpperCases && containsLowerCase && isUpperCaseAndPreviousIsUpperCase)
            ) {
                buf.append(StringPool.UNDERSCORE)
            } else if (Character.isDigit(previousChar) && Character.isLetter(c)) {
                buf.append('_')
            }
            if (shouldReplace(c) && lastOneIsNotUnderscore) {
                buf.append('_')
            } else if (!Character.isWhitespace(c) && (isNotUnderscore || lastOneIsNotUnderscore)) {
                buf.append(Character.toUpperCase(c))
            }
            previousChar = c
        }
        if (Character.isWhitespace(previousChar)) {
            buf.append(StringPool.UNDERSCORE)
        }
        return buf.toString()
    }

    fun containsLowerCase(s: String): Boolean {
        for (c in s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true
            }
        }
        return false
    }

    private fun shouldReplace(c: Char): Boolean {
        return c == '.' || c == '_' || c == '-'
    }

    private fun wordsToHyphenCase(s: String): String {
        val buf = StringBuilder()
        var lastChar = 'a'
        for (c in s.toCharArray()) {
            if (Character.isWhitespace(lastChar) && !Character.isWhitespace(c)
                && '-' != c && buf.length > 0
                && buf[buf.length - 1] != '-'
            ) {
                buf.append(StringPool.DASH)
            }
            if ('_' == c) {
                buf.append('-')
            } else if ('.' == c) {
                buf.append('-')
            } else if (!Character.isWhitespace(c)) {
                buf.append(Character.toLowerCase(c))
            }
            lastChar = c
        }
        if (Character.isWhitespace(lastChar)) {
            buf.append(StringPool.DASH)
        }
        return buf.toString()
    }

    /**
     * 从字符串中移除一个单词及随后的一个逗号
     *
     * @param s 原字符串
     * @param p 移除的单词
     * @return ignore
     */
    @Deprecated("3.1.1")
    fun removeWordWithComma(s: String, p: String): String {
        val match = "\\s*$p\\s*,{0,1}"
        return s.replace(match.toRegex(), "")
    }
}