/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rankings;

/**
 *
 * @author student
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeagueRanks 
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
            System.out.println("Connected in League Ranks");
            
            
            Statement stmt = conn.createStatement();
            
            // CREATING leinsterDiv2 TABLE
            stmt.execute("DROP TABLE IF EXISTS leinsterDiv2;");
            stmt.execute("CREATE TABLE if NOT EXISTS leinsterDiv2(position INT(2),team CHAR(30),played INT(2),won INT(2),lost INT(2),tie INT(2),no_Result INT(2),net_runrate CHAR(9),points INT(2));");
            
            //INSERTING RECORDS
            stmt.execute("INSERT INTO leinsterDiv2 VALUES(1,'Balbriggan',7,6,1,0,0,'+2.564',12)");
            stmt.execute("INSERT INTO leinsterDiv2 VALUES(2,'Cork County 1',7,5,1,0,1,'+2.264',11)");
            stmt.execute("INSERT INTO leinsterDiv2 VALUES(3,'Dublin University',7,5,2,0,0,'+0.371',10)");
            stmt.execute("INSERT INTO leinsterDiv2 VALUES(4,'Malahide',7,4,2,1,0,'+0.136',9)");
            stmt.execute("INSERT INTO leinsterDiv2 VALUES(5,'Railway Union',7,3,3,0,1,'-0.342',7)");
            stmt.execute("INSERT INTO leinsterDiv2 VALUES(6,'Rush',7,3,4,0,0,'-0.753',6)");
            stmt.execute("INSERT INTO leinsterDiv2 VALUES(7,'Terenure',7,2,4,1,0,'-1.854',5)");
            stmt.execute("INSERT INTO leinsterDiv2 VALUES(8,'Trinity',7,1,6,0,0,'-2.218',2)");
            
            // CREATING munsterDiv1 TABLE
            stmt.execute("DROP TABLE IF EXISTS munsterDiv1;");
            stmt.execute("CREATE TABLE if NOT EXISTS munsterDiv1(position INT(2),team CHAR(30),played INT(2),won INT(2),lost INT(2),tie INT(2),no_Result INT(2),net_runrate CHAR(9),points INT(2));");
            
            //INSERTING RECORDS
            stmt.execute("INSERT INTO munsterDiv1 VALUES(1,'Cork County 2',6,6,0,0,0,'+1.827',12)");
            stmt.execute("INSERT INTO munsterDiv1 VALUES(2,'Tipperary County 1',6,4,2,0,0,'+1.707',8)");
            stmt.execute("INSERT INTO munsterDiv1 VALUES(3,'County Kerry',6,4,2,0,0,'-0.085',8)");
            stmt.execute("INSERT INTO munsterDiv1 VALUES(4,'Limerick',6,3,3,0,0,'-0.053',6)");
            stmt.execute("INSERT INTO munsterDiv1 VALUES(5,'Midleton 1',6,2,3,0,1,'-0.933',5)");
            stmt.execute("INSERT INTO munsterDiv1 VALUES(6,'Cork Harlequins 2',6,1,4,0,1,'-2.032',3)");
            stmt.execute("INSERT INTO munsterDiv1 VALUES(7,'Dublin XI',6,1,5,0,0,'-2.723',2)");
            
            
            
             // CREATING munsterDiv2 TABLE
            stmt.execute("DROP TABLE IF EXISTS munsterDiv2;");
            stmt.execute("CREATE TABLE if NOT EXISTS munsterDiv2(position INT(2),team CHAR(30),played INT(2),won INT(2),lost INT(2),tie INT(2),no_Result INT(2),net_runrate CHAR(9),points INT(2));");
            
            //INSERTING RECORDS
            stmt.execute("INSERT INTO munsterDiv2 VALUES(1,'Limerick 4',6,4,1,1,0,'+1.427',9)");
            stmt.execute("INSERT INTO munsterDiv2 VALUES(2,'Cork Harlequins 4',6,4,2,0,0,'+1.507',8)");
            stmt.execute("INSERT INTO munsterDiv2 VALUES(3,'Lismore 1',6,3,2,1,0,'+0.975',7)");
            stmt.execute("INSERT INTO munsterDiv2 VALUES(4,'Cork County 3',6,3,3,0,0,'+0.253',6)");
            stmt.execute("INSERT INTO munsterDiv2 VALUES(5,'Waterford District',6,2,4,0,0,'+0.089',4)");
            stmt.execute("INSERT INTO munsterDiv2 VALUES(6,'Midleton 1',6,2,4,0,0,'-0.012',4)");
            stmt.execute("INSERT INTO munsterDiv2 VALUES(7,'County Clare',6,1,5,0,0,'-1.012',2)");
            
            // CREATING premierDiv TABLE
            stmt.execute("DROP TABLE IF EXISTS premierDiv;");
            stmt.execute("CREATE TABLE if NOT EXISTS premierDiv(position INT(2),team CHAR(30),played INT(2),won INT(2),lost INT(2),tie INT(2),no_Result INT(2),net_runrate CHAR(9),points INT(2));");
            
            //INSERTING RECORDS
            stmt.execute("INSERT INTO premierDiv VALUES(1,'Cork County 1',6,4,2,0,0,'+0.973',8)");
            stmt.execute("INSERT INTO premierDiv VALUES(2,'Tipperary XI',6,3,2,1,0,'+1.212',7)");
            stmt.execute("INSERT INTO premierDiv VALUES(3,'County Galway 1',6,3,3,0,0,'+0.560',6)");
            stmt.execute("INSERT INTO premierDiv VALUES(4,'Midleton',6,3,3,0,0,'-0.012',6)");
            stmt.execute("INSERT INTO premierDiv VALUES(5,'County Kerry',6,2,3,1,0,'+0.589',5)");
            stmt.execute("INSERT INTO premierDiv VALUES(6,'Cork Harlequins 1',6,1,5,0,0,'-1.012',2)");
            stmt.execute("INSERT INTO premierDiv VALUES(7,'Limerick',6,0,6,0,0,'-3.430',0)");
            
            
            
            
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
