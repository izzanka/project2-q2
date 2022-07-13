/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controller.OrderController;
import Controller.OrderDetailController;
import Controller.ShoeController;
import Controller.UserController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "detail", urlPatterns = {"/detail"})
public class DetailServlet extends HttpServlet {
    int userID;
    int orderID;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher dispatch = request.getRequestDispatcher("/detail.jsp");
            dispatch.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
           
            //get current sessionUser
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("sessionUser");
            
            //get paramater then put in variabel
            int qty = Integer.valueOf(request.getParameter("qty"));
            int size = Integer.valueOf(request.getParameter("size"));
            int shoeId = Integer.valueOf(request.getParameter("shoeId"));

            //get data user
            UserController userController = new UserController();
            ResultSet rs1 = userController.getUser(name);
            
            //if success set variabel userID
            if(rs1.next()){
                this.userID = rs1.getInt("id");
            }else{
                System.out.println("no data user");
            }
          
            //get data order by user_id
            OrderController orderController = new OrderController();
            ResultSet rs2 = orderController.checkUser(this.userID);
            
            //if success
            if(rs2.next()){
                //get data shoe
                ShoeController shoeController = new ShoeController();
                ResultSet rs3 = shoeController.getById(shoeId);
                
                //if success
                if(rs3.next()){
                    
                    //set variabel
                    int price = qty * rs3.getInt("price");
                    int total_price = rs2.getInt("total_price") + price;
                    int total_qty = rs2.getInt("total_qty") + qty;

                    orderController.update(this.userID,total_price, total_qty);
                }
                
            }else{
                
                //if failed / not found
                orderController.insert(this.userID,qty,shoeId);
            }
            
            //check if user is already order or not
            OrderDetailController orderDetailController = new OrderDetailController();
            ResultSet rs4 = orderController.checkUser(this.userID);
            
            //if true
            if(rs4.next()){
               
                //insert data to db
               boolean res2 = orderDetailController.insert(qty, size, shoeId, rs4.getInt("id"));
                if(res2){
                    response.sendRedirect("cart");
                }else{
                    System.out.println("order failed!");
                }
            }else{
                System.out.println("user not found!");
            }
         
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
