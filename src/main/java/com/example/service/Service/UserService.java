package com.example.service.Service;

import com.example.service.DAO.DBConnect;
import com.example.service.Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
    public static User getUserbyname(String name){
        User user = new User();
        Statement statement = DBConnect.getInstance().get();
        if(statement != null ){
            try {
                String sql = "SELECT `id`, `name`, `password`, `email`, `urlAvt` FROM `user` where name = ?";
                PreparedStatement ps =   statement.getConnection().prepareStatement(sql);
                ps.setString(1,name);
                ResultSet rs =   ps.executeQuery();

                while (rs.next()){

                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setUrlAvt(rs.getString("urlAvt"));


                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("lỗi kết nối");
        }
        return user;
    }

    public static void main(String[] args) {
        System.out.println(getUserbyname("VU KHAC TAO").toString());
    }

}
