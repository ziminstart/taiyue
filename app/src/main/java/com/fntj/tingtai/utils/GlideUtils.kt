package com.fntj.tingtai.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target


/**
 * @author 恒利
 * @date 2020-10-03 18:42
 * @function 网络请求框架
 */
object GlideUtils {

    /**
     * @param context 安卓上下文
     * @param url 加载图片地址
     * @param imageView 图片加载组件
     * @function 设置正方形图片
     */
    fun squareImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).into(imageView)
    }

    /**
     * @param context 安卓上下文
     * @param url 加载图片地址
     * @param imageView 图片加载组件
     * @function 设置圆形图片
     */
    fun circleCropImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).apply(RequestOptions.bitmapTransform(CircleCrop())).into(imageView)
    }

    /**
     * @param roundingRadius 角度
     * @param context 安卓上下文
     * @param url 加载图片地址
     * @param imageView 图片加载组件
     * @function 设置圆角图片
     */
    fun roundedCornerImage(roundingRadius: Int, context: Context, url: String, imageView: ImageView) {
        //设置图片圆角角度
        val roundedCorners = RoundedCorners(roundingRadius)
        val options = RequestOptions.bitmapTransform(roundedCorners)
        Glide.with(context).load(url).apply(options).into(imageView)
    }

}