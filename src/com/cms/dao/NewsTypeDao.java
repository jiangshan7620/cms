package com.cms.dao;

import com.cms.po.Department;
import com.cms.po.News;
import com.cms.po.NewsType;
import com.cms.util.ConnUtil;

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
 * @date: 2022/8/12 16:35
 * @bz:
 */

public class NewsTypeDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public int getTypeLastId() {
        int i=0;
        try {
            conn= ConnUtil.getConnection();
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

    public List<NewsType> getAllType() {

        List<NewsType> typeList = null;

        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_newstype order by sort";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            typeList = new ArrayList<>();
            while (rs.next()) {

                NewsType type = new NewsType();

                type.setId(rs.getInt("id"));
                type.setTypeName(rs.getString("typeName"));
                type.setSort(rs.getInt("sort"));
                typeList.add(type);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return typeList;

    }

    public int modType(int tid, String typeName, int tsort) {
        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "update tb_newstype set typeName = ? , sort = ?  where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, typeName);
            ps.setInt(2, tsort);
            ps.setInt(3, tid);


            i = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return i;
    }

    public int delTypeById(int tid) {
       int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "delete from tb_newstype where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tid);
            i = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return i;
    }

    public int insertType(String typeName, int tsort) {
        int i = 0;
        try {
            conn = ConnUtil.getConnection();
            String sql = "insert into tb_newstype (typeName , sort) values ( ? , ? )";
            ps = conn.prepareStatement(sql);
            ps.setString(1, typeName);
            ps.setInt(2,tsort);
            i = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return i;
    }

    public int findTypeByName(String typeName) {
        int i=0;
        try {
            conn= ConnUtil.getConnection();
            String sql="select * from tb_newstype where typeName = ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,typeName);
            rs=ps.executeQuery();
            if (rs.next()){
             i=1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return i;
    }

    public List<NewsType> getTypeList() {
        List<NewsType> list=null;
        try {
            conn= ConnUtil.getConnection();
            String sql="select * from tb_newstype order by sort";
            ps=conn.prepareStatement(sql);
           rs=ps.executeQuery();
           list=new ArrayList<NewsType>();
           while(rs.next()){
               NewsType newsType = new NewsType();
               newsType.setSort(rs.getInt("sort"));
               newsType.setId(rs.getInt("id"));
               newsType.setTypeName(rs.getString("typeName"));
               list.add(newsType);
           }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return list;
    }

    public String getTypeNameByid(int typeid) {
        String s=null;
        try {
            conn= ConnUtil.getConnection();
            String sql="select typeName from tb_newstype where id = ?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,typeid);
            rs=ps.executeQuery();

            while(rs.next()){
               s=rs.getString("typeName");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return s;

    }

    public List<News> getList1() {


        List<News> list = null;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where typeid = 1 and flag = 3 order by id desc limit 5";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            list=new ArrayList<News>();
            while(rs.next()){
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setCreatetime(rs.getString("createtime"));
                news.setTypeid(rs.getInt("typeid"));
                news.setContent(rs.getString("content"));
                news.setUid(rs.getInt("uid"));
                news.setId(rs.getInt("id"));
                news.setFlag(rs.getInt("flag"));
                list.add(news);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return list;


    }

    public List<News> getList2() {


        List<News> list = null;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where typeid = 2 and flag = 3 limit 5";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            list=new ArrayList<News>();
            while(rs.next()){
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setCreatetime(rs.getString("createtime"));
                news.setTypeid(rs.getInt("typeid"));
                news.setContent(rs.getString("content"));
                news.setUid(rs.getInt("uid"));
                news.setId(rs.getInt("id"));
                news.setFlag(rs.getInt("flag"));
                list.add(news);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return list;


    }


    public List<News> getList3() {


        List<News> list = null;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where typeid = 3 and flag = 3 limit 5";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            list=new ArrayList<News>();
            while(rs.next()){
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setCreatetime(rs.getString("createtime"));
                news.setTypeid(rs.getInt("typeid"));
                news.setContent(rs.getString("content"));
                news.setUid(rs.getInt("uid"));
                news.setId(rs.getInt("id"));
                news.setFlag(rs.getInt("flag"));
                list.add(news);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return list;


    }

    public List<News> getList4() {


        List<News> list = null;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where typeid = 4 and flag = 3 limit 5";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            list=new ArrayList<News>();
            while(rs.next()){
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setCreatetime(rs.getString("createtime"));
                news.setTypeid(rs.getInt("typeid"));
                news.setContent(rs.getString("content"));
                news.setUid(rs.getInt("uid"));
                news.setId(rs.getInt("id"));
                news.setFlag(rs.getInt("flag"));
                list.add(news);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return list;


    }

    public List<News> getList5() {


        List<News> list = null;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where typeid = 5 and flag = 3 limit 5";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            list=new ArrayList<News>();
            while(rs.next()){
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setCreatetime(rs.getString("createtime"));
                news.setTypeid(rs.getInt("typeid"));
                news.setContent(rs.getString("content"));
                news.setUid(rs.getInt("uid"));
                news.setId(rs.getInt("id"));
                news.setFlag(rs.getInt("flag"));
                list.add(news);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return list;


    }

    public List<News> getList6() {


        List<News> list = null;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where typeid = 15 and flag = 3 limit 5";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            list=new ArrayList<News>();
            while(rs.next()){
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setCreatetime(rs.getString("createtime"));
                news.setTypeid(rs.getInt("typeid"));
                news.setContent(rs.getString("content"));
                news.setUid(rs.getInt("uid"));
                news.setId(rs.getInt("id"));
                news.setFlag(rs.getInt("flag"));
                list.add(news);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return list;


    }

    public List<News> getList7() {


        List<News> list = null;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where typeid = 12 and flag = 3 limit 5";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            list=new ArrayList<News>();
            while(rs.next()){
                News news = new News();
                news.setTitle(rs.getString("title"));
                news.setCreatetime(rs.getString("createtime"));
                news.setTypeid(rs.getInt("typeid"));
                news.setContent(rs.getString("content"));
                news.setUid(rs.getInt("uid"));
                news.setId(rs.getInt("id"));
                news.setFlag(rs.getInt("flag"));
                list.add(news);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return list;


    }







    public int getRowCount(int i) {
        int j=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="select count(*) as count from tb_news where flag=3 and typeid = ? ";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,i);
            rs=ps.executeQuery();
            if (rs.next()){
                j=rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return j;


    }

    public List<News> getNewsList(int pageNowsj, int pageSize, int i) {
        List<News> list = null;

        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where flag=3 and typeid= ? limit  ? , ? ";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,i);
            ps.setInt(2,(pageNowsj-1)*pageSize);
            ps.setInt(3,pageSize);

            rs=ps.executeQuery();
            list=new ArrayList<News>();//这可太拉了！！！！！！！！！！！！！！！！
            while(rs.next()){
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setTypeid(rs.getInt("typeid"));
                n.setFlag(rs.getInt("flag"));
                n.setCreatetime(rs.getString("createtime"));
                n.setUid(rs.getInt("uid"));
                list.add(n);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return list;

    }

    public boolean findTypeSort(int tsort) {
        boolean b=false;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_newstype where sort = ?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,tsort);
            rs=ps.executeQuery();
            if (rs.next()){
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return b;

    }

    public boolean findTypeSortpl(int tsort, int tid) {
        boolean b=false;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_newstype where sort = ? and id != ?";

            ps=conn.prepareStatement(sql);
            ps.setInt(1,tsort);
            ps.setInt(2,tid);
            rs=ps.executeQuery();
            if (rs.next()){
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return b;

    }

    public boolean findTypeByNamepl(String typeName, int tid) {

        boolean b=false;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_newstype where typeName = ? and id != ?";

            ps=conn.prepareStatement(sql);
            ps.setString(1,typeName);
            ps.setInt(2,tid);
            rs=ps.executeQuery();
            if (rs.next()){
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return b;
    }

    public boolean modPd(String typeName, int tsort) {
        boolean b=false;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_newstype where typeName = ? and sort = ?";

            ps=conn.prepareStatement(sql);
            ps.setString(1,typeName);
            ps.setInt(2,tsort);
            rs=ps.executeQuery();
            if (rs.next()){
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return b;

    }
}
