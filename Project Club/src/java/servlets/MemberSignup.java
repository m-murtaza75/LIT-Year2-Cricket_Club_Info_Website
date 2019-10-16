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
@WebServlet(name = "MemberSignup", urlPatterns = {"/MemberSignup"})
public class MemberSignup extends HttpServlet 
{
    String first_name;
    String surname;
    String address;
    String telephone_number;
    String email;
    String password;
    String previous_club;
    String membership_category;
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
            System.out.println("Connected in Member Sign-up Records");
            stat = (Statement) conn.createStatement();
            //stat.execute("DROP TABLE IF EXISTS memberDetails;");
            stat.execute("CREATE TABLE IF NOT EXISTS memberDetails(first_name CHAR(20),surname CHAR(20),address CHAR(35),telephone_number CHAR(10),email CHAR(25),"
                    + "password CHAR(15) NOT NULL,previous_club CHAR(25) DEFAULT 'None',membership_category CHAR(30)," 
                    + "CONSTRAINT email_addr PRIMARY KEY(email));");
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
        first_name = request.getParameter("first_name");
        surname = request.getParameter("surname");
        address = request.getParameter("address");
        telephone_number = request.getParameter("telephone_number");
        email = request.getParameter("email");
        password = request.getParameter("password");
        previous_club = request.getParameter("previous_club");
        membership_category = request.getParameter("membership_category");
        
        try
        {
           if((email.length() != 0 && password.length() != 0))
           {
            String query = "INSERT INTO memberDetails VALUES(?,?,?,?,?,?,?,?)";
            
            prepareStat = (PreparedStatement) conn.prepareStatement(query);
            prepareStat.setString(1,first_name);
            prepareStat.setString(2,surname);
            prepareStat.setString(3,address);
            prepareStat.setString(4,telephone_number);
            prepareStat.setString(5,email);
            prepareStat.setString(6,password);
            if(previous_club.length() == 0)
            {
                previous_club = "None";
                prepareStat.setString(7,previous_club);
            }
            else
            {
                prepareStat.setString(7,previous_club);
            }
            prepareStat.setString(8,membership_category);
            prepareStat.executeUpdate();
            
            //Redirecting to page if all stuff goes right
            response.sendRedirect("RegisterSuccessful.html");
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
