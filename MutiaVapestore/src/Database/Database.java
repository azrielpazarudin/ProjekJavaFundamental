/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Database {
    public Connection Conn;
    public Connection callConn(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost/mutiavapestore","root","");
            System.out.println("Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Conn;
    }
    public static void main(String[] args) {
        Database database = new Database();
        database.callConn();
    }
    
}
