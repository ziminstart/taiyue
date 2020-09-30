package com.fntj.tingtai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fntj.tingtai.R
import com.fntj.tingtai.api.BaseApi
import com.fntj.tingtai.sdk.http.CommonOkHttpClient
import com.fntj.tingtai.sdk.http.listener.DisposeDataHandle
import com.fntj.tingtai.sdk.http.listener.DisposeDataListener
import com.fntj.tingtai.sdk.http.request.CommonRequest
import com.fntj.tingtai.sdk.http.request.RequestParams
import com.fntj.tingtai.sdk.http.response.CommonJsonCallback
import com.fntj.tingtai.view.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_class_layout.*

/**
 * @author 恒利
 * @date 2020-09-20 12:51
 */
class ClassFragment : BaseFragment(), View.OnClickListener {

    private lateinit var mContextView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContext = activity
        mContextView = inflater.inflate(R.layout.fragment_class_layout, container, false)
        return mContextView
    }

    /**
     * view已经创建完成了
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        group_chat_relative_layout.setOnClickListener(this)
        initDates()
    }

    /**
     * 加载数据
     */
    private fun initDates() {
        val mMap = HashMap<String,String>()
        mMap.put("dataKey","z5wh033c7i8")
        mMap.put("userId","88888888888")
        mMap.put("mobile","18210568221")

        CommonOkHttpClient.sendRequest(
            CommonRequest.createPostRequest(BaseApi.HOME_DATA, RequestParams()),
            CommonJsonCallback(DisposeDataHandle(object : DisposeDataListener {
                override fun onSuccess(responseObj: Any?) {
                    println("请求成功")
                }

                override fun onFailure(reasonObj: Any?) {
                    println("请求失败")
                }
            }))
        )
    }

    /**
     * 初始化java-websocket
     */
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(v: View?) {
    }


}