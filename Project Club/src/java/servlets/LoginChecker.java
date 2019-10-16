/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "LoginChecker", urlPatterns = {"/LoginChecker"})
public class LoginChecker extends HttpServlet 
{
    String email;
    String password;
    Connection conn;
    PreparedStatement prepareStat;
    Statement stat;
    
    public void init() throws ServletException
    {
        String URL = "jdbc:mysql://localhost:3306/";
        String DB = "mydb";
        String USERNAME = "root";
        String PASSWORD = "password";
        String driver = "com.mysql.jdbc.Driver";
        
        try
        {
            Class.forName(driver).newInstance();
            //Setup the connection with the Database
            conn = (Connection) DriverManager.getConnection(URL+DB,USERNAME,PASSWORD);
            System.out.println("Connected in Login Checker Servlet");
            
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }

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
            throws ServletException, IOException 
    {
        email = request.getParameter("email");
        password = request.getParameter("password");
        
        try
        {
            String query = "SELECT * FROM memberDetails WHERE email = ? AND password = ?";
            prepareStat = (PreparedStatement) conn.prepareStatement(query);
            prepareStat.setString(1,email);
            prepareStat.setString(2,password);
            ResultSet result = prepareStat.executeQuery();
            boolean found = true;
            
            if(result.next() == found)
            {
                //Redirecting to page if all stuff goes right
                response.sendRedirect("sign-in-successful.html");
            }
            else if(result.next() != found)
            {
                response.sendRedirect("invalidDetail.html");
                             
            }
             
            
            
        }
        catch(Exception e)
        {
            System.err.println(e);
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
        processRequest(request, response);
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
