/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import Query.UserQuery;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class UserController extends Controller {
    UserModel userModel = new UserModel();
    
    public boolean register(UserModel userModel){
        try {
            pst = conn.prepareStatement(UserQuery.register);
            pst.setString(1, userModel.getName());
            pst.setString(2, userModel.getEmail());
            pst.setString(3, userModel.getPassword());
            int rows = pst.executeUpdate();
            return rows != 0;
        } catch (SQLException e) {
            return false;
        }
     
    }
    
    public ResultSet login(UserModel userModel){
        try{
            pst = conn.prepareStatement(UserQuery.login);
            pst.setString(1, userModel.getEmail());
            pst.setString(2, userModel.getPassword());
            rs = pst.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    public ResultSet getUser(String name){
        try{
            pst = conn.prepareStatement(UserQuery.getUser);
            pst.setString(1, name);
            rs = pst.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rs;
    }
}
