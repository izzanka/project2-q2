/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Query.OrderQuery;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class OrderController extends Controller {
        
    public ResultSet checkUser(int user_id){
        try{
            pst = conn.prepareStatement(OrderQuery.checkUser);
            pst.setInt(1, user_id);
            pst.setString(2, "on cart");
            rs = pst.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage()); 
        }
        return rs;
    }
    
    public boolean insert(int userId, int qty, int shoeId){
        try{
            ShoeController shoeController = new ShoeController();
            ResultSet rs1 = shoeController.getById(shoeId);

            if(rs1.next()){
                int totalPrice = rs1.getInt("price") * qty;

                pst = conn.prepareStatement(OrderQuery.insert);
                pst.setInt(1, userId);
                pst.setString(2, "on cart");
                pst.setInt(3, qty);
                pst.setInt(4, totalPrice);
                int rows = pst.executeUpdate();
                return rows != 0;
                
            }else{
                return false;
            }
           
        }catch(SQLException e){
            System.out.println(e.getMessage()); 
            return false;
        }
    }
    
    public boolean update(int user_id, int total_price, int total_qty){
        try{
            pst = conn.prepareStatement(OrderQuery.update);
            pst.setInt(1, total_qty);
            pst.setInt(2, total_price);
            pst.setInt(3, user_id);
            pst.setString(4, "on cart");
            int rows = pst.executeUpdate();
            return rows != 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateStatus(int id){
            try{
            pst = conn.prepareStatement(OrderQuery.updateStatus);
            pst.setString(1, "ordered");
            pst.setInt(2, id);
            int rows = pst.executeUpdate();
            return rows != 0;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
