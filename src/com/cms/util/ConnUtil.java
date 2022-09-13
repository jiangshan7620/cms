package com.cms.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: Mr.shan
 * @date: 2022/8/3 9:11
 * @bz:
 */

public class ConnUtil {

    private static DataSource dataSource = new ComboPooledDataSource();

    public static Connection getConnection() {
        try {

            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public static void close(ResultSet rs, PreparedStatement preparedStatement, Connection connection ) {
        // 关闭资源
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (connection != null) {
            try {
                connection.close(); // 关闭,其实是交还给池子来处理
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
