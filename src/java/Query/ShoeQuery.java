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
public class ShoeQuery {
    public static String getAll = "SELECT s.*,c.name AS category_name FROM shoes s INNER JOIN categories c ON s.category_id = c.id ORDER BY s.sold DESC LIMIT 4";
    public static String getByCategory = "SELECT s.*,c.name AS category_name FROM shoes s INNER JOIN categories c ON s.category_id = c.id WHERE s.category_id = ? ORDER BY s.sold DESC LIMIT 4";
    public static String getById = "SELECT s.*,c.name AS category_name FROM shoes s INNER JOIN categories c ON s.category_id = c.id WHERE s.id = ?";
    public static String getByRelated = "SELECT * FROM shoes WHERE id <> ? AND category_id = ? ORDER BY sold DESC LIMIT 4";
    public static String insert  = "INSERT INTO shoes(category_id, name, description, price, sold, stock, size, images) VALUES (?,?,?,?,?,?,?,?)";
    public static String getNews = "SELECT s.*,c.name AS category_name FROM shoes s INNER JOIN categories c ON s.category_id = c.id WHERE s.id > 12 ORDER BY s.id DESC LIMIT 4";
}
