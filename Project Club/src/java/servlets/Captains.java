/*
Author: Muhammad Murtaza
Student ID: K00223470
Page no: 2.1 Club Captains
 */
package servlets;

import com.mysql.jdbc.Connection;
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
@WebServlet(name = "Captains", urlPatterns = {"/Captains"})
public class Captains extends HttpServlet 
{
    Connection conn;
    
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
            System.out.println("Connected in Captains Servlet");
            
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
        Statement stmt;
            
            //Set response content type
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            String title = "Club Captains History";
            String docType = "<!doctype html>";
            out.println(docType + "<html>\n" +
                    "<head> <title>" + title + "</title>" +
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"clubStyling.css\">" +
                    "</head>" +
                    "<body>\n" +
                    "<div class=\"wrapper\">" +
                    "<header>" +
                    "<img src=\"Club_Logo/badge.jpg\" width=\"130\" height=\"150\">\n" +
                    "<br><br>\n" +
                    "<h1>Cork County Cricket Club</h1>\n"
                    + "<div class=\"navigation\">" +
                    "<nav>" +
                    "<ul>\n" +
                    "<li><a href=\"index.html\">Home</a></li>  \n" +
                    "<li><a href=\"about_us.html\">About Us</a>"
                    + "<ul>\n" +
                    "<li><a href=\"Captains\">Club Captains</a></li><br>"
                    +"<li><a href=\"newsEvent.html\">News & Events</a></li>\n" +
                    "</ul>\n" +
                    "</li>\n" +
                    "<li><a href=\"Rankings\">Rankings</a></li>\n" +
                    "<li><a href=\"contact_us.html\">Contact Us</a></li>\n" +
                    "<li><a href=\"#\">Become Member</a>\n" +
                    "<ul>\n" +
                    "<li><a href=\"sign_up.html\">Register</a></li>\n" +
                    "<li><a href=\"sign_in.html\">Sign In</a></li>\n" +
                    "</ul>\n" +
                    "</li>\n" +
                    "</ul>\n" +
                    "</nav>\n"
                    + "</div>" +
                    "</header>\n" +
                    "<br><br><br><br><br><br><br>" +
                    "<center>\n" +
                    "<img src=\"captains/captains.png\" width=\"750\" height=\"290\" alt=\"Group photo of Captains\">\n" +
                    "<h3 style=\"color: white; font-family: calibri; font-size: 80px;\">Club Captains</h3></center>" +
                    "<center>" +
                    "<table style=\"width:70%;\" border =\"5\">\n" + 
                    "<tr>" + 
                    "<th style=\"color:appworkspace; background-color:white;\">Club Captain</th>" +
                    "<th style=\"color:appworkspace; background-color:white;\">Year(s)</th>" +
                    "</tr>");
            
            try
            {
                //Execute SQL Query
                
                stmt = (Statement) conn.createStatement();
                
                String sql;
                
                sql = "SELECT Name,Years FROM captainDetails";
                
                ResultSet rs = stmt.executeQuery(sql);
                
                //Extract data from result set
                while(rs.next())
                {
                    //Retrieve by column name
                    String name = rs.getString("Name");
                    String years = rs.getString("Years");
                    
                    out.println("<tr>" + 
                                "<td style=\"color:white; background-color:black;\">" + name + "</td>");           
                    out.println("<td style=\"color:white; background-color:black;\">" + years + "</td>\n" +
                                "</tr>");
                    
                }
                out.println("</table></center><br><br>"
                                + "<footer> <center> <img src=\"Club_Logo/badge.jpg\" width=\"50\" height=\"50\"> <h2>Cork County Cricket Club</h2> "
                                + "<h6>Richard Beamish Cricket Grounds,</h6>"
                                + "<h6>Mardyke, Cork, T12 YN61, Ireland.</h6>"
                                + "<h6>+353 (0)21 4272569</h6>"
                                + "<h6>corkcountycc@gmail.com</h6>"
                                + "<h6>Copyright © 2018 Cork County Cricket Club.</h6> </center> </div></footer>");
                out.println("</body></html>");
            }
            catch(Exception e)
            {
                e.printStackTrace();
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
