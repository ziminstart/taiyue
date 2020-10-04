package com.fntj.tingtai.bean;


import com.fntj.tingtai.bean.base.IEntity;

/**
 * <p>
 * 教师表
 * </p>
 *
 * @author 恒利
 * @since 2020-05-14
 */
public class Teacher extends IEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 教师名称
     */
    private String name;

    /**
     * 真实名称
     */
    private String realName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 教师类型(0班主任,1教师,2助教)
     */
    private Integer type;

    /**
     * 班级Id
     */
    private Long classId;

    /**
     * 是否开启消息免打扰
     */
    private Long isNotDisturb = 0L;

    /**
     * 消息数量
     */
    private Integer chatNums = 0;

    /**
     * 最近的一条消息
     */
    private String msg = "";

    /**
     * 最近一条消息的时间
     */
    private Long timestamp = 0L;

    /**
     * 最近一条消息的时间
     */
    private Integer msgType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getIsNotDisturb() {
        return isNotDisturb;
    }

    public void setIsNotDisturb(Long isNotDisturb) {
        this.isNotDisturb = isNotDisturb;
    }

    public Integer getChatNums() {
        return chatNums;
    }

    public void setChatNums(Integer chatNums) {
        this.chatNums = chatNums;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }
}
