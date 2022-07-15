/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controller.ShoeController;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "shoe", urlPatterns = {"/shoe"})
public class ShoeServlet extends HttpServlet {

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
                RequestDispatcher dispatch = request.getRequestDispatcher("/shoe.jsp");
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
        
        HttpSession session = request.getSession();
        
        String category_id = request.getParameter("category_id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String size = request.getParameter("size");
        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String image3 = request.getParameter("image3");
        String image4 = request.getParameter("image4");

       
        if(category_id.isEmpty() || name.isEmpty() || description.isEmpty() || price.isEmpty() || stock.isEmpty() || size.isEmpty() 
                || image1.isEmpty() || image2.isEmpty() || image3.isEmpty() || image4.isEmpty()){
               session.setAttribute("isEmpty","true");
               response.sendRedirect("shoe");
        }else{
            ShoeController sc = new ShoeController();
            boolean res = sc.insert(Integer.valueOf(category_id), name, description, Integer.valueOf(price), Integer.valueOf(stock), Integer.valueOf(size), image1, image2, image3, image4);
            if(res){
                response.sendRedirect("index");
            }else{
                session.setAttribute("isDuplicate","true");
                response.sendRedirect("shoe");
            }
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
