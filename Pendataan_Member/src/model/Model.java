package model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Model {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbmembershipvp";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    public Model() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readData(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][5]; 
            
            String query = "SELECT * FROM data_membervp"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("NoHP"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("nama");                
                data[jmlData][2] = String.valueOf(resultSet.getInt("masaBerlaku"));
                data[jmlData][3] = resultSet.getString("tipe_member");
                data[jmlData][4] = resultSet.getString("tanggal");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    
    public void insertData(String NoHP, String Nama, int Masa, String Tipe, String Tanggal){
        int jmlData=0;
        
        try {
           String query = "SELECT * FROM data_membervp WHERE NoHP='" + NoHP+"'"; 
           System.out.println(NoHP + " " + Nama + " " + Masa + " " + Tipe + " " + Tanggal);
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO data_membervp(NoHP,nama,masaBerlaku,tipe_member,tanggal) VALUES('"+NoHP+"','"+Nama+"','"+Masa+"','"+Tipe+"','"+Tanggal+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Member Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String NoHP, String Nama, int Masa, String Tipe, String Tanggal){
        int jmlData=0;
         try {
           String query = "SELECT * FROM data_membervp WHERE NoHP='" + NoHP+"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE data_membervp SET nama='" + Nama + "', masaBerlaku='" + Masa + "', tipe_member='"+ Tipe+"', tanggal='"+ Tanggal+"' WHERE NoHP='" + NoHP+"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Data berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "  Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM data_membervp";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteData (String NoHP) {
        try{
            String query = "DELETE FROM data_membervp WHERE NoHP = '"+NoHP+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
