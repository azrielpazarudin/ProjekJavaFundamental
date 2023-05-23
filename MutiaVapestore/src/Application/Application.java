package Application;

import java.sql.*;
import Model.*;
import Database.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javax.swing.JFileChooser;

public class Application {

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        Database db = new Database();
        DAO myDao = new DAO();
        Connection Conn = db.callConn();
        InputStream is = null;
        Model mod =new Model();
        PreparedStatement ps = null;
        try {
         //   ps = Conn.prepareCall("insert into logo values (14,?)");
           // 
           // ps =Conn.prepareCall("update produk set harga = 110000 where idProduk='PR049'");
            JFileChooser openFile = new JFileChooser("E:/Java/ProjekJavaFundamental/Database/Resource");
            File pf = new File("");
            int res = openFile.showOpenDialog(null);
            if (res == JFileChooser.APPROVE_OPTION) {
                pf = openFile.getSelectedFile();
                String w = pf.getAbsoluteFile().toString();
                is = new FileInputStream(new File(w));
             
                ps.setBinaryStream(1, is);
                int result = ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (is != null) {
                is.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }
}
