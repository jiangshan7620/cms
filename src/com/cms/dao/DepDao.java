package com.cms.dao;

import com.cms.po.Department;
import com.cms.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Mr.shan
 * @date: 2022/8/3 21:39
 * @bz:
 */

public class DepDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public List<Department> getAllDep() {  //查找，封装，返回数组
        List<Department> departmentList = null;

        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_department order by sort";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            departmentList = new ArrayList<>();
            while (rs.next()) {
                Department dep = new Department();
                dep.setId(rs.getInt("id"));
                dep.setDepName(rs.getString("depName"));
                dep.setDepCreateTime(rs.getString("depCreateTime"));
                dep.setSort(rs.getInt("sort"));
                departmentList.add(dep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return departmentList;
    }

    public int findDepByName(String depname) {
        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_department where depName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, depname);
            rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }


        return i;
    }

    public int addDep(Department dep) {
        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "insert into tb_department (depName , depCreateTime) values(? , ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dep.getDepName());
            ps.setString(2, dep.getDepCreateTime());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return i;
    }

    public int getLastId() {
        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_department order by id desc limit 1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                i = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return i;

    }

    public int delDepById(int did) {

        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "delete from tb_department where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, did);
            i = ps.executeUpdate();//删除成功数

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return i;
    }

    public int modDep(int did, String depName, int dsort) {

        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "update tb_department set depName = ? , sort = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, depName);
            ps.setInt(2, dsort);
            ps.setInt(3, did);


            i = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return i;
    }

    public int insertDep(String depName, int dsort, String time) {
        int i = 0;

        try {
            conn = ConnUtil.getConnection();
            String sql = "insert into tb_department (depName,depCreateTime,sort) values ( ? , ? ,? )";
            ps=conn.prepareStatement(sql);
            ps.setString(1,depName);
            ps.setString(2,time);
            ps.setInt(3,dsort);
            i=ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);

        }

        return i;
    }

    public int getTypeLastId() {
        int i=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="select id from tb_newstype order by id desc limit 1";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()){
                i=rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return i;
    }

    public int findDepByNameAndID(String depName, int did) {
        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_department where depName = ? and id != ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, depName);
            ps.setInt(2,did);
            rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }


        return i;
    }

    public int findDepBySort(int dsort) {
        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_department where sort = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dsort);

            rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }


        return i;
    }

    public int findDepBySortAndID(int dsort, int did) {
        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_department where sort = ? and id != ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dsort);
            ps.setInt(2, did);


            rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }


        return i;
    }

    public int modPd(int dsort, String depName) {
        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_department where sort = ? and depName = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dsort);
            ps.setString(2,depName);


            rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }


        return i;
    }
}
