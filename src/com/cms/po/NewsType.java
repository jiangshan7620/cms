package com.cms.po;

/**
 * @author: Mr.shan
 * @date: 2022/8/6 10:28
 * @bz:
 */

public class NewsType {
    private int id;
    private String typeName;
    private int sort;

    public NewsType() {
    }

    public NewsType(int id, String typeName, int sort) {
        this.id = id;
        this.typeName = typeName;
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "NewsType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", sort=" + sort +
                '}';
    }
}
