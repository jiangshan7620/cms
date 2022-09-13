package com.cms.dao;

import com.cms.po.News;
import com.cms.po.NewsType;
import com.cms.po.User;
import com.cms.util.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.shan
 * @date: 2022/8/6 10:33
 * @bz:
 */

public class NewsDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public List<NewsType> getNewsType() {
        List<NewsType> list = null;
        try {
            conn = ConnUtil.getConnection();
            String sql = "select * from tb_newstype";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<NewsType>();

            while (rs.next()) {
                NewsType newsType = new NewsType();
                newsType.setId(rs.getInt("id"));
                newsType.setSort(rs.getInt("sort"));
                newsType.setTypeName(rs.getString("typeName"));
                list.add(newsType);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, null);
        }

        return list;

    }

    public int getRowCount(News news, int pageNow, int pageSize, User user) {

        int i = 0;
        int index = 1;
        try {
            conn = ConnUtil.getConnection();

            StringBuffer sb = new StringBuffer();
            sb.append("select count(*)as total from tb_news where 1 = 1");
            if (news.getTypeid() != 0) {
                sb.append(" and typeid = ?");
            }

            if (news.getFlag() != 0) {
                sb.append(" and flag = ?");
            }

            if (news.getTitle() != null && !"".equals(news.getTitle())) {
                sb.append(" and title like ? ");
            }

            if (user.getUserPower()==0){
                sb.append(" and uid = ?");
            }
            String sql = sb.toString();
            ps = conn.prepareStatement(sql);
            if (news.getTypeid() != 0) {
                ps.setInt(index++, news.getTypeid());
            }
            if (news.getFlag() != 0) {
                ps.setInt(index++, news.getFlag());
            }

            if (news.getTitle() != null && !"".equals(news.getTitle())) {
                ps.setString(index++, "%" + news.getTitle() + "%");
            }

            if (user.getUserPower()==0){
                ps.setInt(index++,user.getId());
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                i = rs.getInt("total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }

        return i;


    }


    public List<News> getNewsList(News news, int pageNow, int pageSize, User user) {
        List<News> list = null;
        int index = 1;

        try {
            conn = ConnUtil.getConnection();
            StringBuffer sb = new StringBuffer();
            sb.append("select a.*,b.userName from tb_news as a LEFT JOIN tb_users as b on a.uid=b.id where 1 = 1");
            if (news.getTypeid() != 0) {
                sb.append(" and typeid = ?");
            }
            if (news.getFlag() != 0) {
                sb.append(" and flag = ?");
            }
            if (news.getTitle() != null && !"".equals(news.getTitle())) {
                sb.append(" and title like ?");
            }
            if (user.getUserPower()==0){
                sb.append(" and uid= ? ");
            }

            sb.append(" order by id desc limit ? , ? ");
            String sql = sb.toString();


            ps = conn.prepareStatement(sql);

            if (news.getTypeid() != 0) {
                ps.setInt(index++, news.getTypeid());
            }
            if (news.getFlag() != 0) {
                ps.setInt(index++, news.getFlag());
            }

            if (news.getTitle() != null && !"".equals(news.getTitle())) {
                ps.setString(index++,"%"+ news.getTitle()+"%");
            }
            if (user.getUserPower()==0){
                ps.setInt(index++,user.getId());
            }


            ps.setInt(index++, (pageNow - 1) * pageSize);
            ps.setInt(index++, pageSize);


            rs = ps.executeQuery();
            list = new ArrayList<News>();
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("a.id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setTypeid(rs.getInt("typeid"));
                n.setFlag(rs.getInt("flag"));
                n.setCreatetime(rs.getString("createtime"));
                n.setUid(rs.getInt("uid"));
                n.setUserName(rs.getString("userName"));
                list.add(n);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            ConnUtil.close(rs, ps, conn);
        }
        return list;


    }

    public int getLastID() {
        int id = 1;
        try {
            conn = ConnUtil.getConnection();
            String sql = "select id from tb_news ORDER BY id desc limit 1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs, ps, conn);
        }
        return id;
    }


    public int addNews(News news) {
        int i=0;
        int index=1;
        try {
            conn=ConnUtil.getConnection();
            String sql="insert into tb_news values (default,?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(index++,news.getTitle());
            ps.setString(index++,news.getContent());
            ps.setInt(index++,news.getTypeid());
            ps.setInt(index++,news.getFlag());
            ps.setString(index++,news.getCreatetime());
            ps.setInt(index++,news.getUid());

            i = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }

        return i;

    }


    public News getNewsById(int nid) {
        News news=null;

        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where id = ?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,nid);
            rs=ps.executeQuery();
            if (rs.next()){
                 news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setTypeid(rs.getInt("typeid"));
                news.setFlag(rs.getInt("flag"));
                news.setCreatetime(rs.getString("createtime"));
                news.setUid(rs.getInt("uid"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }

        return news;

    }

    public int modNews(News news) {

        int index=1;
        int i=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="update tb_news set typeid = ? , flag = ? , title = ? , content = ? where id = ?";
            ps=conn.prepareStatement(sql);
            ps.setInt(index++,news.getTypeid());
            ps.setInt(index++,news.getFlag());
            ps.setString(index++,news.getTitle());
            ps.setString(index++,news.getContent());
            ps.setInt(index++,news.getId());
           i= ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return i;
    }

    public int delNewsById(int id) {
        int i=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="delete from tb_news where id = ? " ;
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            i =ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        System.out.println("========删除（为1，则成功）======");
        System.out.println(i);
        return i;
    }

    public int findNewsByUid(int uid) {
        int i=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where uid = ?";
            ps=conn.prepareStatement(sql);

            ps.setInt(1,uid);
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

    public int setState(int state,int id) {
        int j=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="update tb_news set flag = ? where id = ? ";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,state);
            ps.setInt(2,id);
            j=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }

        return j;

    }

    public int getStateById(int id) {
        int m=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="select flag from tb_news where id = ? ";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if (rs.next()){
                m=rs.getInt("flag");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return m;
    }

    public boolean findNewsByTypeid(int tid) {
        boolean b=false;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where typeid = ?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,tid);
            rs=ps.executeQuery();
            while (rs.next()){
                b=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return b;


    }

    public List<News> getNewsByTypeId(int i) {
        List<News> list = null;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where typeid = ? and flag = 3";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,i);
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


    public int findNewsByTitle(int uid,String title) {
        int i=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="select * from tb_news where title = ? and uid = ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,title);
            ps.setInt(2,uid);
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

    public int checkModNews(News news) {
        int i=0;
        try {
            conn=ConnUtil.getConnection();
            StringBuffer sb= new StringBuffer();
            sb.append("select * from tb_news where 1 = 1");
            if (news.getContent()!=null){
                sb.append(" and content = ? ");
            }
            if (news.getUid()!=0){
                sb.append(" and uid = ?");
            }
            if(news.getTypeid()!=-1){
                sb.append(" and typeid = ?");
            }
            if(news.getTitle()!=null){
                sb.append(" and title = ?");
            }
            String sql=sb.toString();
            ps=conn.prepareStatement(sql);
            ps.setString(1,news.getContent());
            ps.setInt(2,news.getUid());
            ps.setInt(3,news.getTypeid());
            ps.setString(4,news.getTitle());

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


    public int findFlagByNewsid(int mid) {
        int i=0;
        try {
            conn=ConnUtil.getConnection();
            String sql="select flag from tb_news where id = ?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,mid);
            rs=ps.executeQuery();
            if(rs.next()){
                i=rs.getInt("flag");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.close(rs,ps,conn);
        }
        return i;
    }
}

