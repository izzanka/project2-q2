/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Query.OrderQuery;
import Query.ShoeQuery;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ShoeController extends Controller{
      public ResultSet getAll(boolean news){
        try {
            if(news){
                pst = conn.prepareStatement(ShoeQuery.getNews);
            }else{
                pst = conn.prepareStatement(ShoeQuery.getAll);
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
      
    public ResultSet getByCategory(int id,int category_id, boolean related){
        try {
            if(related){
                pst = conn.prepareStatement(ShoeQuery.getByRelated);
                pst.setInt(1, id);
                pst.setInt(2, category_id);
            }else{
                pst = conn.prepareStatement(ShoeQuery.getByCategory);
                pst.setInt(1, id);
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    public ResultSet getById(int id){
        try {
            pst = conn.prepareStatement(ShoeQuery.getById);
            pst.setInt(1, id);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    public boolean insert(int categoryId, String name, String description, int price, int stock, int size, String image1, String image2, String image3, String image4){
        try{
            
            List<String> objList = new ArrayList<>();
            objList.add(0, image1);
            objList.add(1, image2);
            objList.add(2, image3);
            objList.add(3, image4);
            
            int sold = (int)Math.floor(Math.random()*(50-1+1)+1);
            
            String imgJson = new Gson().toJson(objList);
            System.out.println(imgJson);
         
            pst = conn.prepareStatement(ShoeQuery.insert);
            pst.setInt(1, categoryId);
            pst.setString(2, name.toUpperCase());
            pst.setString(3, description);
            pst.setInt(4, price);
            pst.setInt(5, sold);
            pst.setInt(6, stock);
            pst.setInt(7, size);
            pst.setString(8, imgJson);
            int rows = pst.executeUpdate();
            return rows != 0;

        }catch(SQLException e){
            System.out.println(e.getMessage()); 
            return false;
        }
    }
}
