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
public class UserQuery {
    public static String login = "SELECT * FROM users WHERE email = ? AND password = ?";
    public static String register = "INSERT INTO users (name,email,password) VALUES (?,?,?)";
    public static String getUser = "SELECT * FROM users WHERE name = ?";
}
