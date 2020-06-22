
package dgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class db_connect {
    
   
    public void storeScore(){
         String playerName = Data.Name;
         int playerScore = Data.kills;
         
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaProject","root","prajji");
            java.sql.Statement smt = conn.createStatement();
            
            smt.executeUpdate("insert into scoreCard values ('"+playerName+"','"+playerScore+"')");
            
            conn.close();
        
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showScore(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaProject","root","prajji");
            java.sql.Statement smt = conn.createStatement();
            
            ResultSet rs = smt.executeQuery("select * from scorecard order by Score DESC");
            JTable table = new JTable(buildTableModel(rs));
            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(db_connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
    
    
}
