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

/**
 * Copy to jodd.util
 *
 *
 * Pool of `String` constants to prevent repeating of
 * hard-coded `String` literals in the code.
 * Due to fact that these are `public static final`
 * they will be inlined by java compiler and
 * reference to this class will be dropped.
 * There is **no** performance gain of using this pool.
 * Read: https://java.sun.com/docs/books/jls/third_edition/html/lexical.html#3.10.5
 *
 *  * Literal strings within the same class in the same package represent references to the same `String` object.
 *  * Literal strings within different classes in the same package represent references to the same `String` object.
 *  * Literal strings within different classes in different packages likewise represent references to the same `String` object.
 *  * Strings computed by constant expressions are computed at compile time and then treated as if they were literals.
 *  * Strings computed by concatenation at run time are newly created and therefore distinct.
 *
 */
interface StringPool {
    companion object {
        const val AMPERSAND = "&"
        const val AND = "and"
        const val AT = "@"
        const val ASTERISK = "*"
        const val STAR = ASTERISK
        const val BACK_SLASH = "\\"
        const val COLON = ":"
        const val COMMA = ","
        const val DASH = "-"
        const val DOLLAR = "$"
        const val DOT = "."
        const val DOTDOT = ".."
        const val DOT_CLASS = ".class"
        const val DOT_JAVA = ".java"
        const val DOT_XML = ".xml"
        const val EMPTY = ""
        const val EQUALS = "="
        const val FALSE = "false"
        const val SLASH = "/"
        const val HASH = "#"
        const val HAT = "^"
        const val LEFT_BRACE = "{"
        const val LEFT_BRACKET = "("
        const val LEFT_CHEV = "<"
        const val DOT_NEWLINE = ",\n"
        const val NEWLINE = "\n"
        const val N = "n"
        const val NO = "no"
        const val NULL = "null"
        const val OFF = "off"
        const val ON = "on"
        const val PERCENT = "%"
        const val PIPE = "|"
        const val PLUS = "+"
        const val QUESTION_MARK = "?"
        const val EXCLAMATION_MARK = "!"
        const val QUOTE = "\""
        const val RETURN = "\r"
        const val TAB = "\t"
        const val RIGHT_BRACE = "}"
        const val RIGHT_BRACKET = ")"
        const val RIGHT_CHEV = ">"
        const val SEMICOLON = ";"
        const val SINGLE_QUOTE = "'"
        const val BACKTICK = "`"
        const val SPACE = " "
        const val TILDA = "~"
        const val LEFT_SQ_BRACKET = "["
        const val RIGHT_SQ_BRACKET = "]"
        const val TRUE = "true"
        const val UNDERSCORE = "_"
        const val UTF_8 = "UTF-8"
        const val US_ASCII = "US-ASCII"
        const val ISO_8859_1 = "ISO-8859-1"
        const val Y = "y"
        const val YES = "yes"
        const val ONE = "1"
        const val ZERO = "0"
        const val DOLLAR_LEFT_BRACE = "\${"
        const val HASH_LEFT_BRACE = "#{"
        const val CRLF = "\r\n"
        const val HTML_NBSP = "&nbsp;"
        const val HTML_AMP = "&amp"
        const val HTML_QUOTE = "&quot;"
        const val HTML_LT = "&lt;"
        const val HTML_GT = "&gt;"

        // ---------------------------------------------------------------- array
        val EMPTY_ARRAY = arrayOfNulls<String>(0)
        val BYTES_NEW_LINE = NEWLINE.toByteArray()
    }
}