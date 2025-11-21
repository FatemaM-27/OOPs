package com.JDBC;
import java.sql.*;

public class JDBCDemo2 {
    public static void main(String[] args) throws Exception {
//        int id=106;
//        String name="Aakash";
//        int balance =2000;

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/sampledb";
        String user="root";
        String password="root";
        Connection conn= DriverManager.getConnection(url,user,password);

        String query="insert into accounts values(?,?,?)";
        PreparedStatement ps=conn.prepareStatement(query);
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setInt(3,balance);
        int result =ps.executeUpdate();

        String query2="select * from accounts";
        ps.executeQuery(query2);
        ResultSet rs= ps.executeQuery(query2);
        while(rs.next()){
            System.out.println(rs.getInt(1)+ " "+rs.getString(2)+ " "+rs.getInt(3));
        }
        String query3="delete from accounts where id=106";
        int result2=ps.executeUpdate(query3);
        ps.executeUpdate(query3);

        System.out.println(result +" rows are affected");
        conn.close();

    }
}
