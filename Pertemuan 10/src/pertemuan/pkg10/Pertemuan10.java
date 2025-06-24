/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pertemuan.pkg10;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author suciantari
 * 20 Mei 2025
 */
public class Pertemuan10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        dbkoneksi cnn = new dbkoneksi ();   
        Statement st = cnn.koneksi().createStatement();
        
        String sql = "SELECT * FROM mhs;";
        ResultSet res = st.executeQuery(sql);
        
        while ( res.next()){
            
            System.out.println("Nama  : "+res.getString("NAMA"));
            System.out.println("NIM   : "+res.getString("NIM"));
            //System.out.println("Prodi : "+res.getString("PRODI"));
            System.out.println("Alamat: "+res.getString("ALAMAT"));
        }
    }
    
}
