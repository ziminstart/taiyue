package com.fntj.tingtai.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.TypeReference
import com.fntj.tingtai.R
import com.fntj.tingtai.api.BaseApi
import com.fntj.tingtai.bean.Teacher
import com.fntj.tingtai.sdk.http.CommonOkHttpClient
import com.fntj.tingtai.sdk.http.listener.DisposeDataHandle
import com.fntj.tingtai.sdk.http.listener.DisposeDataListener
import com.fntj.tingtai.sdk.http.request.CommonRequest
import com.fntj.tingtai.sdk.http.response.CommonJsonCallback
import com.fntj.tingtai.view.fragment.base.BaseFragment
import com.fntj.tingtai.view.item.TeacherItemAdapter
import kotlinx.android.synthetic.main.fragment_class_layout.*
import java.util.*
import kotlin.collections.HashMap

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
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        teacher_list_recycler_view.layoutManager = linearLayoutManager
        //设置数据
        initDates()
    }

    /**
     * 加载数据
     */
    private fun initDates() {
        val mMap = HashMap<String, String>()
        mMap.put("dataKey", "z5wh033c7i8")
        mMap.put("userId", "88888888888")
        mMap.put("mobile", "18210568221")
        mMap.put("source", "BANWOXUE")

        CommonOkHttpClient.sendRequest(
            CommonRequest.createPostRequest(BaseApi.HOME_DATA, mMap),
            CommonJsonCallback(DisposeDataHandle(object : DisposeDataListener {
                override fun onSuccess(responseObj: Any?) {
                    val parseObj = JSON.parseObject(responseObj.toString())
                    if (parseObj["success"] as Boolean) {
                        val entity = JSON.parseObject(parseObj["entity"]?.toString(),
                            object : TypeReference<Map<String, String>>() {})
                        val featureListJson = entity["featureList"]
                        val featureList = JSON.parseArray(featureListJson)
                        val teacherListJson = entity["teacherList"]
                        val teacherList: List<Teacher> = JSON.parseArray(teacherListJson, Teacher::class.java)
                        teacher_list_recycler_view.adapter = TeacherItemAdapter(teacherList)
                        val classListJson = entity["classList"]
                        val classList = JSON.parseArray(classListJson)
                    } else {
                        if (parseObj["status"].toString().toInt() == 11001) {
                            Toast.makeText(context, parseObj["message"] as String, Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                override fun onFailure(reasonObj: Any?) {
                    println("请求出错")
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