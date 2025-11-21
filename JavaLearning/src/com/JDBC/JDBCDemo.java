package com.JDBC;
import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/sampledb";
        String username="root";
        String password="root";
        Connection conn = DriverManager.getConnection(url,username,password);

        Statement stmt=conn.createStatement();
//        String query1="insert into accounts values(103,\"Nisha\",6500)";
        String query2="delete from accounts where id=103";
        int result=stmt.executeUpdate(query2);
        stmt.executeUpdate(query2);
        System.out.println(result+" rows affected");

        String query="select * from accounts";
        stmt.executeQuery(query);
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getInt(1)+ " "+rs.getString(2)+ " "+rs.getInt(3));

        }
//        System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3));
        conn.close();
    }
}
