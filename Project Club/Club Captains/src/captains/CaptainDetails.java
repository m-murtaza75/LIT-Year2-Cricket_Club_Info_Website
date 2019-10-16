/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captains;

/**
 *
 * @author student
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CaptainDetails 
{
    public static void main(String[] args) throws SQLException
    {
        String URL = "jdbc:mysql://localhost:3306/";
        
        String DB = "mydb";
        
        String USERNAME = "root";
        
        String PASSWORD = "password";
        
        Connection conn = null;
        
        try
        {
            //Setup the connection with the DB 
            
            conn = DriverManager.getConnection(URL + DB,USERNAME,PASSWORD);
            System.out.println("Connected in Captain Details");
            
            
            Statement stmt = conn.createStatement();
            
            // CREATING captainDetails TABLE
            stmt.execute("DROP TABLE IF EXISTS captainDetails;");
            stmt.execute("CREATE TABLE if NOT EXISTS captainDetails(Name CHAR(40),Years CHAR(25));");
            
            
            //INSERTING RECORDS
            stmt.execute("INSERT INTO captainDetails VALUES('Cormac Hassett','2018')");
            stmt.execute("INSERT INTO captainDetails VALUES('Stephan Grobler','2015, 2016 & 2017')");
            stmt.execute("INSERT INTO captainDetails VALUES('Ross Durity','2014,2012')");
            stmt.execute("INSERT INTO captainDetails VALUES('Andrew Wootton','2013')");
            stmt.execute("INSERT INTO captainDetails VALUES('Bruce Koch','2011')");
            
            stmt.execute("INSERT INTO captainDetails VALUES('Robert Duggan','2010,2003 & 2004')");
            stmt.execute("INSERT INTO captainDetails VALUES('Keith Banks','2008,2009 & 2005')");
            stmt.execute("INSERT INTO captainDetails VALUES('Stephen Hickey','2006 & 2007')");
            stmt.execute("INSERT INTO captainDetails VALUES('Ted Williamson','2000, 2001 & 2002')");
            stmt.execute("INSERT INTO captainDetails VALUES('Shane Connole','1999,1997 & 1995')");
            stmt.execute("INSERT INTO captainDetails VALUES('Paddy Tynan','1998,1996,1971 & 1972')");
            stmt.execute("INSERT INTO captainDetails VALUES('John V. T. Power','1994')");
            stmt.execute("INSERT INTO captainDetails VALUES('Peter Dineen','1992 & 1993')");
            stmt.execute("INSERT INTO captainDetails VALUES('Noel Giltinan','1991')");
            stmt.execute("INSERT INTO captainDetails VALUES('David Griffin','1989 & 1990')");
            stmt.execute("INSERT INTO captainDetails VALUES('Brian O Donnell','1988,1974 & 1975')");
            stmt.execute("INSERT INTO captainDetails VALUES('Roger Wilson','1987')");
            stmt.execute("INSERT INTO captainDetails VALUES('Dermot Giltinan','1985 & 1986')");
            stmt.execute("INSERT INTO captainDetails VALUES('Pat J. Dineen','1984,1978,1974 & 1973')");
            stmt.execute("INSERT INTO captainDetails VALUES('John Whittaker','1983')");
            stmt.execute("INSERT INTO captainDetails VALUES('W. Booton','1970')");
            stmt.execute("INSERT INTO captainDetails VALUES('M. J. Wolridge','1976')");
            stmt.execute("INSERT INTO captainDetails VALUES('Ronnie McDowell','1982')");
            stmt.execute("INSERT INTO captainDetails VALUES('P. Davies','1981')");
            stmt.execute("INSERT INTO captainDetails VALUES('F. Creedon','1980')");
            stmt.execute("INSERT INTO captainDetails VALUES('Paddy Tynan','1979')");
            stmt.execute("INSERT INTO captainDetails VALUES('Leo Durity','1977')");           
            

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            if(conn!=null)
            {
                conn.close();
            }
        }       
    }
    
}
