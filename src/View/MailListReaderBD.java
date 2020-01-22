package View;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MailListReaderBD {
    public MailListReaderBD(){}

    public List<String> read(String url, String table) throws IOException{
        List<String> mails = new ArrayList<>();
        String sql = "SELECT * FROM " + table;
        try (Connection conn = DriverManager.getConnection(url); 
                Statement stmt = conn.createStatement(); 
                ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) { 
                mails.add(rs.getString("mail")); 
            } 
        } catch (SQLException e) { 
            System.out.println(e.getMessage()); 
        }
        return mails;
    }

}