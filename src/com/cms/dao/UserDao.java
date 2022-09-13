package com.cms.dao;

import com.cms.po.User;
import com.cms.util.ConnUtil;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Mr.shan
 * @date: 2022/8/3 9:05
 * @bz:
 */

public class UserDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public User checkUser(User user) {
        User saveUser=null;
        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_users where userName = ? and userPwd = ? ";

//            System.out.println(user.getUserPwd());
//            System.out.println(user.getUserName());

            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPwd());
            rs = ps.executeQuery();

            if (rs.next()){
                 saveUser = new User();
                 saveUser.setUserName(rs.getString("userName"));
                saveUser.setUserPwd(rs.getString("userPwd"));
                saveUser.setDepID(rs.getInt("depID"));
                saveUser.setId(rs.getInt("id"));
                saveUser.setUserAge(rs.getInt("userAge"));
                saveUser.setUserCode(rs.getString("userCode"));
                saveUser.setUserSex(rs.getString("userSex"));
                saveUser.setUserPower(rs.getInt("userPower"));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return saveUser;

    }


    public int getRowCount(User user) {
        try {
            conn = ConnUtil.getConnection();
            StringBuffer sb = new StringBuffer();
            //条件变量
            int index = 0;
            sb.append("select count(*) as total from tb_users where 1=1 ");
            if (user.getUserName() != null && !"".equals(user.getUserName().trim())) {
                sb.append(" and userName like ?");
            }
            if (user.getDepID() != 0) {
                sb.append(" and depID=?");
            }
            String sql = sb.toString();

            ps = conn.prepareStatement(sql);
            if (user.getUserName() != null && !"".equals(user.getUserName().trim())) {
                ps.setString(++index, "%" + user.getUserName() + "%");
            }
            if (user.getDepID() != 0) {
                ps.setInt(++index, user.getDepID());
            }
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return 0;
    }



    //返回满足条件的用户列表
    public List<User> getUserList(User user,int pageNow,int pageSize){
        List<User> userList=null;
        try {
            conn=ConnUtil.getConnection();
            StringBuffer sb = new StringBuffer();
            int index=0;
            sb.append("select * from tb_users where 1=1 ");
            if(user.getUserName()!=null&&!"".equals(user.getUserName().trim())) {
                sb.append(" and userName like ?");
            }
            if (user.getDepID()!=0){
                sb.append(" and depID=?");
            }
            sb.append(" order by id desc limit ?,?");
            ps=conn.prepareStatement(sb.toString());

            if (user.getUserName()!=null){
                ps.setString(++index,"%"+user.getUserName()+"%");
            }
            if(user.getDepID()!=0){
                ps.setInt(++index,user.getDepID());
            }
            ps.setInt(++index,(pageNow-1)*pageSize);
            ps.setInt(++index,pageSize);



            rs=ps.executeQuery();
            userList = new ArrayList<>();
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUserPower(rs.getInt("userPower"));
                u.setDepID(rs.getInt("depID"));
                u.setUserAge(rs.getInt("userAge"));
                u.setUserCode(rs.getString("userCode"));
                u.setUserPwd(rs.getString("userPwd"));
                u.setUserName(rs.getString("userName"));
                u.setUserSex(rs.getString("userSex"));
                userList.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return userList;
    }


    public boolean addUser(User user) {
        boolean b=false;
        int index=1;
        try {
            conn=ConnUtil.getConnection();
            String sql="insert into tb_users (depID,userName,userCode,userPwd,userSex,userAge\n" +
                    ",userPower) VALUES(?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setInt(index++,user.getDepID());
            ps.setString(index++,user.getUserName());
            ps.setString(index++,user.getUserCode());

            ps.setString(index++,user.getUserPwd());

            ps.setString(index++,user.getUserSex());
            ps.setInt(index++,user.getUserAge());
            ps.setInt(index++,user.getUserPower());
            int i = ps.executeUpdate();
            if (i==1){
               b=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return b;


    }

    public boolean findUserByName(String username) {
        boolean b=false;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_users where userName=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            rs=ps.executeQuery();
            if(rs.next()){
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return b;
    }

    public int delUserById(int uid) {
        int i=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="delete from tb_users where id = ? ";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,uid);
            i = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return i;
    }

    public boolean modifyUserByID(User user) {
        boolean b=false;
        int index=1;
        try {
            conn=ConnUtil.getConnection();
            String sql = "update tb_users set depID=?,userName=?,userPwd=?,userCode=?,userSex=?,userAge=?,userPower=? where id = ?";

            ps=conn.prepareStatement(sql);
            ps.setInt(index++,user.getDepID());
            ps.setString(index++,user.getUserName());


            ps.setString(index++,user.getUserPwd());
            ps.setString(index++,user.getUserCode());

            ps.setString(index++,user.getUserSex());
            ps.setInt(index++,user.getUserAge());
            ps.setInt(index++,user.getUserPower());
            ps.setInt(index++,user.getId());
            int i = ps.executeUpdate();

            System.out.println("i的值为");
            System.out.println(i);
            if (i==1){
                b=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return b;
    }


    public User findUserByID(int uid) {
        User u = new User();
        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_users where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            if (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUserPower(rs.getInt("userPower"));
                u.setDepID(rs.getInt("depID"));
                u.setUserAge(rs.getInt("userAge"));
                u.setUserCode(rs.getString("userCode"));
                u.setUserPwd(rs.getString("userPwd"));
                u.setUserName(rs.getString("userName"));
                u.setUserSex(rs.getString("userSex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return u;
    }


    public int getLastID() {
        int id=1;
        try {
            conn=ConnUtil.getConnection();
            String sql="select id from tb_users ORDER BY id desc limit 1";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()){
                id=rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return id;


    }

    public boolean findUserByDid(int did) {
        boolean b=false;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_users where depID = ?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,did);
            rs=ps.executeQuery();
            if (rs.next()){
                b = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return b;
    }

    public Map getSexMap() {
      Map map= new HashMap<Integer,String>();
      map.put(0,"男");
      map.put(1,"女");
      return map;

    }

//    public Map<Integer, String> getAllName() {
//       Map map=null;
//        try {
//            conn=ConnUtil.getConnection();
//            String sql="select *from tb_users";
//            ps=conn.prepareStatement(sql);
//            rs=ps.executeQuery();
//           map= new HashMap<Integer,String>();
//            while (rs.next()){
//                map.put(rs.getInt("id"),rs.getString("userName"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            ConnUtil.close(rs,ps,conn);
//        }
//        return map;
//
//    }
}
