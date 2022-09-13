package com.cms.po;

/**
 * @author: Mr.shan
 * @date: 2022/8/6 10:18
 * @bz:
 */

public class News {
    private int id;
    private String title;
    private String content;
    private int typeid;
    private int flag;
    private String createtime;
    private int uid;
    private String userName;

    public News() {
    }

    public News(int id, String title, String content, int typeid, int flag, String createtime, int uid, String userName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.typeid = typeid;
        this.flag = flag;
        this.createtime = createtime;
        this.uid = uid;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", typeid=" + typeid +
                ", flag=" + flag +
                ", createtime='" + createtime + '\'' +
                ", uid=" + uid +
                ", userName='" + userName + '\'' +
                '}';
    }
}
