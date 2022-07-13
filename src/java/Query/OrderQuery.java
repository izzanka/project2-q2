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
public class OrderQuery {
    public static String checkUser = "SELECT * FROM orders WHERE user_id = ? AND status = ?";
    public static String insert = "INSERT INTO orders(user_id,status,total_qty,total_price) VALUES (?,?,?,?)";
    public static String update = "UPDATE orders SET total_qty = ?, total_price = ? WHERE user_id = ? AND status = ?";
    public static String get = "SELECT * FROM orders WHERE user_id = ? AND status = ? ORDER BY id DESC";
    public static String updateStatus = "UPDATE orders SET status = ? WHERE id = ? ";
}
