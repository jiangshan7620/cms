package com.cms.po;

import java.util.Date;

/**
 * @author: Mr.shan
 * @date: 2022/8/3 8:38
 * @bz:
 */

public class Department {
    private int Id;
    private String depName;
    private String depCreateTime;
    private int sort;

    public Department() {
    }

    public Department(int id, String depName, String depCreateTime, int sort) {
        Id = id;
        this.depName = depName;
       this.depCreateTime=depCreateTime;
        this.sort = sort;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepCreateTime() {
        return depCreateTime;
    }

    public void setDepCreateTime(String depCreateTime) {
        this.depCreateTime = depCreateTime;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Department{" +
                "Id=" + Id +
                ", depName='" + depName + '\'' +
                ", depCreateTime=" + depCreateTime +
                ", sort=" + sort +
                '}';
    }


}
