/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Query.OrderDetailQuery;
import Query.OrderQuery;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class OrderDetailController extends Controller {
    
    public boolean insert(int qty, int size, int shoeId, int orderId){
        try{
            ShoeController shoeController = new ShoeController();
            ResultSet rs1 = shoeController.getById(shoeId);

            if(rs1.next()){
                int totalPrice = rs1.getInt("price") * qty;

                pst = conn.prepareStatement(OrderDetailQuery.insert);
                pst.setInt(1, rs1.getInt("id"));
                pst.setInt(2, orderId);
                pst.setInt(3, qty);
                pst.setInt(4, size);
                pst.setInt(5, totalPrice);
                int rows = pst.executeUpdate();
                return rows != 0;
            }else{
                System.out.println("shoe data not found!");
                return false;
            }
           
        }catch(SQLException e){
            System.out.println(e.getMessage()); 
            return false;
        }
    }
    
    public ResultSet get(int order_id){
        try{
            pst = conn.prepareStatement(OrderDetailQuery.get);
            pst.setInt(1, order_id);
            rs = pst.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage()); 
        }
        return rs;
    }
    
}
