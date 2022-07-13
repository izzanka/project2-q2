/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

/**
 *
 * @author ASUS
 */
public class OrderDetailQuery {
    public static String insert = "INSERT INTO order_details(shoe_id,order_id,qty,size,total_price) VALUES (?,?,?,?,?)";
    public static String get = "SELECT o.*, s.* FROM order_details o INNER JOIN shoes s ON o.shoe_id = s.id WHERE order_id = ?";
}
