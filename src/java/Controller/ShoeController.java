/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Query.ShoeQuery;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ShoeController extends Controller{
      public ResultSet getAll(){
        try {
            pst = conn.prepareStatement(ShoeQuery.getAll);
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
}
