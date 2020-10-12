package com.fntj.tingtai.view.item

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fntj.tingtai.R
import com.fntj.tingtai.bean.Teacher
import com.fntj.tingtai.utils.GlideUtils
import com.fntj.tingtai.utils.StringUtils
import com.fntj.tingtai.view.activity.HomeActivity

/**
 * 老师列表循环
 */
class TeacherItemAdapter(private var teachers: List<Teacher>) :
    RecyclerView.Adapter<TeacherItemAdapter.InnerTeacher>() {

    /**
     * 初始化老师
     */
    private lateinit var context: Context;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerTeacher {
        this.context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_teacher_adapter, parent, false)
        return InnerTeacher(itemView)
    }

    /**
     * 返回列表数量
     */
    override fun getItemCount(): Int {
        return this.teachers.size
    }

    /**
     * 遍历老师列表数据
     */
    override fun onBindViewHolder(holder: InnerTeacher, position: Int) {
        val teacher = teachers[position]
        //设置老师头像
        if (StringUtils.isNotBlank(teacher.avatar)) GlideUtils.circleCropImage(
            context, teacher.avatar, holder.teacherAvatarImageView
        )
        else holder.teacherAvatarImageView.setImageResource(R.mipmap.icon_photo)
        //设置老师名称
        if (StringUtils.isNotBlank(teacher.name)) holder.teacherNameTextView.text = teacher.name
        //设置上次聊天的内容
        if (StringUtils.isNotBlank(teacher.msg)) holder.chatMessageTextView.text = teacher.msg
        else holder.chatMessageTextView.text = ""
        //设置时间戳
        if (teacher.timestamp != 0L) holder.chatTimestampTextView.text = "~" else holder.chatTimestampTextView.text = ""

        //设置点击事件
        holder.teacherContainerRelativeLayout.setOnClickListener { toChatAty(teacher) }
    }

    private fun toChatAty(teacher: Teacher) {
        val intent = Intent()
        intent.setClass(context, HomeActivity::class.java)
        intent.putExtra("teacherId", teacher.id)
        intent.putExtra("classId", teacher.classId)
        context.startActivity(intent)
    }


    inner class InnerTeacher(itemView: View) : ViewHolder(itemView) {
        //总容器
        var teacherContainerRelativeLayout =
            itemView.findViewById(R.id.teacher_container_relative_layout) as RelativeLayout

        // 老师头像
        var teacherAvatarImageView = itemView.findViewById(R.id.teacher_avatar_image_view) as ImageView

        // 老师名称
        var teacherNameTextView = itemView.findViewById(R.id.teacher_name_text_view) as TextView

        // 聊天信息
        var chatMessageTextView = itemView.findViewById(R.id.chat_message_text_view) as TextView

        // 聊天时间戳
        var chatTimestampTextView = itemView.findViewById(R.id.chat_timestamp_text_view) as TextView
    }
}