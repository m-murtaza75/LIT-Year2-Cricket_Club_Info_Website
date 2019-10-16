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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "MemberMessage", urlPatterns = {"/MemberMessage"})
public class MemberMessage extends HttpServlet 
{
    String name;
    String email_address;
    String subject;
    String message;
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
            System.out.println("Connected in Member Message Records");
            stat = (Statement) conn.createStatement();
            //stat.execute("DROP TABLE IF EXISTS memberMessage");
            stat.execute("CREATE TABLE IF NOT EXISTS memberMessage(name CHAR(30),email_address CHAR(25),subject CHAR(30),message CHAR(150) DEFAULT NULL);");
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
        name = request.getParameter("name");
        email_address = request.getParameter("email_address");
        subject = request.getParameter("subject");
        message = request.getParameter("message");
        
        try
        {
            if((message.length() != 0 && email_address.length() != 0))
            {
           
            String query = "INSERT INTO memberMessage VALUES(?,?,?,?)";
            
            prepareStat = (PreparedStatement) conn.prepareStatement(query);
            prepareStat.setString(1,name);
            prepareStat.setString(2,email_address);
            prepareStat.setString(3,subject);
            prepareStat.setString(4,message);
            prepareStat.executeUpdate();
            
            //Redirecting to page if all stuff goes right
            response.sendRedirect("messageSent.html");
            }
            else
            {
               response.sendRedirect("wrongInput.html");
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
