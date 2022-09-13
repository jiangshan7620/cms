package com.cms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: Mr.shan
 * @date: 2022/8/3 14:12
 * @bz:
 */

public class VisitedUtil {
    //读取访问次数
    public static int readVisited(){
        int res=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_visited";
            ps=conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                res=rs.getInt("visited");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return res;
    }
    //写入访问次数
    public static void writeVisited(int res){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn=ConnUtil.getConnection();
            String sql="update tb_visited set visited=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,res);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(null,ps,conn);
        }
    }
}
